package com.Sort.heapsort;

/**
 * 堆排序
 */

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 3, 4, 5, 3, 4, 8,9 ,67,654 , 456};
        h_sort.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

/**
 *理解的关键就在于它是从下往上的
 * 第一次非叶子结点的子节点没有子节点，所以循环会直接退出
 * 当时到第三次，第四次就会向子节点的子节点探，这个时候因为是从下到上的
 * 所以往下探时，它遍历的都是大顶堆
 * 向下探视可能遇到子节点还是比你要比较的那个值大，这个时候就再将已经探到的值赋给这个较大值
 * 再循环的结尾，就是把最小值给挪到最下面的子节点处
 *
 */
class h_sort{


    public static void sort(int[] array){
        int t;
        //将数组大顶堆化
        //这里体现了从下到上，从左到右
        //根据二叉树的性质，第一个非叶子结点再length / 2处，且减一后就是右边的他的上一个结点
        for (int i = array.length / 2; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        for (int i = array.length - 1; i > 0 ; i--) {
            t= array[0];
            array[0] = array[i];
            array[i] = t;
            adjustHeap(array, 0, i - 1);
        }
    }

    /**
     *
     * @param array 要化成大顶堆的数组
     * @param i 开始的非叶子结点
     * @param length 需要进行大顶堆化的数组长度
     */
    public static void adjustHeap(int[] array, int i, int length){
        int temp = array[i];
        for (int j = 2 * i + 1;j < length; j = j * 2 + 1){
            if(j + 1 < length && array[j] < array[j + 1]){
                j++;
            }
            if(temp >= array[j]){
                break;
            }
            array[i] = array[j];
            i = j;
        }
        array[i] = temp;
    }
}
