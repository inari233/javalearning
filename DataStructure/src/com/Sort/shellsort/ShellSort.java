package com.Sort.shellsort;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 1, 7, 5, 6, 8, 7};
        S_sort.sort3(array);
        for (int i : array) {
            System.out.print(i);
        }
    }
}

class S_sort {
    /**
     * 交换法希尔排序
     *
     * @param array 要排序的数组
     */
    public static void sort1(int[] array) {
        int temp;
        int gap = 0;
        for (gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < array.length; ++i) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
    }


    public static void sort2(int[] array) {
        int gap = 0;
        int insertVal;
        int insertIndex;
        for (gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                insertVal = array[i];
                insertIndex = i;
                if (array[insertIndex] < array[insertIndex - gap]) {
                    while (insertIndex - gap >= 0 && insertVal < array[insertIndex - gap]) {
                        array[insertIndex] = array[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    array[insertIndex] = insertVal;
                }
            }
        }
    }

    public static void sort3(int[] array) {
        int gap;
        int index;
        int value;
        for (gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                index = i;
                value = array[i];
                if(array[index] < array[index - gap]){
                    while (index - gap >= 0 && array[index] < array[index - gap]){
                        array[index] = array[index - gap];
                        index -= gap;
                    }
                    array[index] = value;
                }
            }

        }
    }
}
