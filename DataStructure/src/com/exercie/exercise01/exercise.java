package com.exercie.exercise01;


/**
 * 用于巩固算法的联系文件，可以来这里重新写一遍算法加深理解
 */
public class exercise {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 3, 4, 5, 3, 4, 8, 9, 67, 654, 456};
        int[] t = new int[array.length];
        q_sort.sort1(array, 0, array.length - 1, t);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

class q_sort {

    public static void sort(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        int pivot = array[mid];

        int l = left;
        int r = right;
        int t = 0;

        while (l < r) {
            while (array[l] < pivot) {
                l++;
            }
            while (array[r] > pivot) {
                --r;
            }

            if (l == r) {
                break;
            }
            t = array[l];
            array[l] = array[r];
            array[r] = t;

            if (array[l] == pivot) {
                --r;
            }

            if (array[r] == pivot) {
                ++l;
            }

        }

        if (l == r) {
            --r;
            ++l;
        }
        if (left < r) {
            sort(array, left, r);
        }
        if (right > l) {
            sort(array, l, right);
        }
    }


    public static void sort1(int[] array, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (right + left) / 2;
            sort1(array, left, mid, temp);
            sort1(array, mid + 1, right, temp);
            merge(array, left, mid, right, temp);
        }
    }

    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int l = left;
        int r = mid + 1;
        int t = 0;

        while (l <= mid && r <= right) {
            if (array[l] < array[r]) {
                temp[t] = array[l++];
            } else {
                temp[t] = array[r++];
            }
            ++t;
        }

        while (l <= mid) {
            temp[t++] = array[l++];
        }
        while (r <= right) {
            temp[t++] = array[r++];
        }

        int index = 0;
        int insertIndex = left;
        while (index < t) {
            array[insertIndex++] = temp[index++];
        }
    }

    public static void sort2(){

    }
}


