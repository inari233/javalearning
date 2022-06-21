package com.Sort.insertsort;

/**
 * 插入排序，思想就和理扑克牌一样
 * 思想的核心在于将值后移的处理和对边界的处理
 * 心得：
 * 在想要将数组进行向后移位时，可以先将被覆盖的值保留下来
 * 然后再将每个值都覆盖后移
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 4, 1, 2, 6};
        I_sort.sort(array);
        for (int i : array) {
            System.out.print(i);
        }
    }
}

class I_sort{
    public static void sort(int[] array){
        int insertVal;
        int insertIndex;
        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < array[insertIndex] ){
                array[insertIndex + 1] = array[insertIndex];
                --insertIndex;
            }
            array[insertIndex + 1] = insertVal;
        }
    }
}
