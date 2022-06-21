package com.LeetCode;

import java.util.Arrays;

public class nextPermutation01 {
    public static void main(String[] args) {
        int[] ints = {3, 2, 1};
        nextPermutation01 next = new nextPermutation01();
        next.nextPermutation(ints);
        System.out.println(Arrays.toString(ints));
    }

    public void nextPermutation(int[] nums) {
        int size = nums.length;
        int modify = size - 2;
        while (modify > 0 && nums[modify] >= nums[modify + 1]) {
            --modify;
        }
        int j = size - 1;
        int min = 10, index = 0;
        while (j > modify) {
            if (nums[j] > nums[modify] && nums[j] < min) {
                min = nums[j];
                index = j;
            }
            j--;
        }
        swap(nums, modify, index);
        if (modify == 0) {
            reverse(nums, 0, size - 1);
        } else reverse(nums, modify + 1, size - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] temp, int left, int right) {
        while (left < right) {
            swap(temp, left, right);
            left++;
            right--;
        }
    }

}
