package com.LeetCode;

public class removeElement01 {
    public static void main(String[] args) {
        int[] array = {3, 2, 2, 3};

    }

    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                ++i;
                j++;
            } else {
                j++;
            }
        }
        return i + 1;
    }
}
