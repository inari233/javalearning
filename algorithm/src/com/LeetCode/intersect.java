package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，
 * 应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 */
public class intersect {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 2};
        int[] ints1 = {1, 2, 3};
        int[] ints2 = intersect1(ints1, ints);
        for (int i : ints2) {
            System.out.println(i);
        }
    }

    public static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int j = 0, i = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                j++;

            } else if (nums1[i] == nums2[j]) {
                arrayList.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            }
        }

        int[] newArray = new int[arrayList.size()];
        int t = 0;
        for (Integer integer : arrayList) {
            newArray[t++] = integer;
        }
        return newArray;
    }
}
