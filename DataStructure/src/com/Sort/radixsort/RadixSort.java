package com.Sort.radixsort;

/**
 * 基数排序，本质就是空间换时间
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 3, 4, 5, 3, 4, 8,9 ,67,654 , 456};
        R_sort.sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

class R_sort{

    public static void sort(int[] array){
        int max = array[0];
        for (int i : array) {
            if(i > max){
                max = i;
            }
        }
        int[][] bucket = new int[10][array.length];//用来存放每个位数的桶
        int[] bucketCount = new int[10];//用来存放每个桶里元素个数的数组
        int digit;//拿来计较的位数，比如个位，十位，百位
        int n = 1;//用来累乘的数，作用就是依次取出个位，十位，百位。。。。。。
        int max_digit = (max + "").length();//用来求最大位数的快捷方法
        for (int i = 0; i < max_digit; i++, n *= 10) {
            for (int value : array) {
                digit = value / n % 10;
                bucket[digit][bucketCount[digit]++] = value;//将数据放入到对应的桶中，并且让计数器+1
            }
            int index = 0;//用于给原数组复制的辅助索引
            for (int k = 0; k < 10; k++) {
                if(bucketCount[k] != 0){//当该桶的计数器不为零时才从该桶取出数据
                    for (int j = 0; j < bucketCount[k]; j++) {
                        array[index++] = bucket[k][j];
                    }
                }
                bucketCount[k] = 0;//一定记得把计数器清零，不然下一次进行分类的时候，就会出错
            }
        }
    }
}
