package com.Sort.bubblesort;

public class Bubble {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 4, 6, 1, 3};
        B_sort.sort(array);
        for (int i : array) {
            System.out.print(i);
        }


    }
}

class B_sort {
    public static void sort(int[] array) {
        int t;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }
}
