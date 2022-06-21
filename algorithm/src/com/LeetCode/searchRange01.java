package com.LeetCode;

import java.util.Arrays;

public class searchRange01 {
    public static void main(String[] args) {
        searchRange01 range01 = new searchRange01();
        int[] array = {1};
        int[] ints = range01.searchRange(array, 5);
        System.out.println(Arrays.toString(ints));
    }


    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)return new int[]{-1, -1};
        int left = 0;
        int right = nums.length;
        int[] res = new int[2];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left >= nums.length || nums[left] != target) res[0] = -1;
        else res[0] = left;
        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == 0 || nums[left - 1] != target) res[1] = -1;
        else res[1] = left - 1;
        return res;
    }
}
