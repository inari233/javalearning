package com.Sort.selectsort;

/**
 * 选择排序
 */
public class Select {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 4, 6, 1, 9};
        S_sort.sort(array);
        for (int i : array) {
            System.out.print(i);
        }
    }
}

class S_sort{
    public static void sort(int[] array){
        int max = 0;
        int maxIndex = 0;
        int t;
        for (int i = 0; i < array.length - 1; i++) {
            max = array[i];
            maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if(array[j] > max){
                    max = array[j];
                    maxIndex = j;
                }
            }
            array[maxIndex] = array[i];
            array[i] = max;
        }
    }
}
