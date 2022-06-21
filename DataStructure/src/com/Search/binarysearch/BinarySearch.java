package com.Search.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 3, 135,423,5423,154,33};
        Arrays.sort(array);
        List<Integer> search = b_search.search(array, 423, 0, array.length - 1);
        for (Integer integer : search) {
            System.out.println(integer);
        }
    }
}

class b_search {
    public static List<Integer> search(int[] array, int findValue, int left, int right) {
        int mid = (left + right) / 2;
        int midValue = array[mid];
        if (right >= left) {
            if (findValue > midValue) {
                return search(array, findValue, mid + 1, right);
            } else if (findValue < midValue) {
                return search(array, findValue, left, mid);
            } else {
                List<Integer> arrayList = new ArrayList<>();
                int t = mid - 1;
                while (true){
                    if (t < 0 || array[t] != findValue){
                        break;
                    }
                    arrayList.add(t);
                    t--;
                }
                arrayList.add(mid);
                t = mid + 1;
                while (true){
                    if (t > array.length -1  || array[t] != findValue){
                        break;
                    }
                    arrayList.add(t);
                    t++;
                }
                return arrayList;
            }
        } else {
            return null;
        }
    }
}
