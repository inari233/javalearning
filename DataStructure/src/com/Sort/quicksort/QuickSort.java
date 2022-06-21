package com.Sort.quicksort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 3, 4, 5, 3, 4, 8,9 ,67,654 , 456};
        Q_sort.sort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

class Q_sort {
    /**
     * 防止两个中间值交换以后还是两个中间值，没有发生改变
     * 所以要在比较完后进行手动的移位，不让就会出现两个pivot无限进行交换，陷入死讯环
     * @param array 用于排序的数组
     */
    public static void sort(int[] array, int left, int right) {
        int l = left;//左边开始寻找的位置
        int r = right;//右边开始寻找的位置
        int pivot = array[(left + right) / 2];//把数组中间的值拿来当作分组的数
        int t;//用于进行交换的辅助变量
        //只有当l == r 或者l > r的时候退出
        //
        while (l < r) {
            //用于寻找左边大于等于pivot的数，最差的情况就是找到pivot本身
            while (array[l] < pivot) {
                ++l;
            }
            //用于寻找右边小于等于pivot的数，最差的情况就是找到pivot本身
            while (array[r] > pivot) {
                --r;
            }

            //满足这个条件
            //可以进行画图理解，左边一直找都没有比pivot大的值直到找到了pivot
            //右边一直到都没有找到比pivot小的值直到找到了pivot
            //这个时候说明pivot右边的都是大于等于它的，左边的都是小于等于它的
            //就可以退出
            if (l >= r) {
                break;
            }

            t = array[l];
            array[l] = array[r];
            array[r] = t;

            //用于排除两个相等的pivot，即l和r都指向值等于pivot的情况
            //如果不进行错开就会l和r一直都找到pivot两个进行无限的交换
            //而此时分组还没有完成就退出了，所以加入这个判断条件来将两者错开
            if (array[l] == pivot) {
                r--;
            }
            if (array[r] == pivot) {
                l++;
            }
        }
        //两者都指向pivot
        //加入这个就可以错开，这样l就指向右递归的左边界
        //r就指向左递归的有边界
        if(l == r){
            l++;
            r--;
        }
        //进行判断，如果l和left相等，就说明已经让左边只有一个值即left本身指向的值，就可以结束递归交换了
        //进行左递归
        if (left < l){
            sort(array, left, r);
        }
        //进行右递归
        if(right > l){
            sort(array, l, right);
        }
    }
}
