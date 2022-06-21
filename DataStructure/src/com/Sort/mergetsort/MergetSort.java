package com.Sort.mergetsort;

/**
 * 归并排序
 */

public class MergetSort {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 8, 6, 7, 3, 8, 9, 7, 746, 6, 423};
        int[] temp = new int[array.length];
        M_sort.sort(array, 0, array.length - 1, temp);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

class M_sort {

    public static void sort(int[] array, int left,int right, int[] temp){
        //一直分到只有一个元素为止
        if(left < right){
            int mid = (left + right) / 2;
            //左递归
            sort(array, left, mid, temp);
            //右递归
            sort(array, mid + 1, right, temp);
            //合并
            merge(array, left, mid, right, temp);
        }



    }


    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int t = 0;
        int l = left;
        int r = mid + 1;
        //左边的有序数组和右边的有序数组依次从头开始比较
        //那边数组的小就将其先拷贝到temp数组中
        //然后将指针后移
        while (l <= mid && r <= right) {
            if (array[l] <= array[r]) {
                temp[t] = array[l];
                ++l;
            } else {
                temp[t] = array[r];
                ++r;
            }
            ++t;
        }
        //如果一边拷贝完了，另一边还没拷贝完，就将没有拷贝完的那边依次直接加入到temp数组中
        while (l <= mid) {
            temp[t] = array[l];
            ++l;
            ++t;
        }

        while (r <= right) {
            temp[t] = array[r];
            ++r;
            ++t;
        }

        //将temp数组拷贝到原数组中
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            array[tempLeft] = temp[t];
            ++t;
            ++tempLeft;
        }
    }
}
