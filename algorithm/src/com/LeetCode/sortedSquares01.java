package com.LeetCode;

import java.util.Arrays;

public class sortedSquares01 {
    public static void main(String[] args) {
        int[] ints = {-7,-3,2,3,11};
        sortedSquares01 sort = new sortedSquares01();
        int[] ints1 = sort.sortedSquares(ints);
        System.out.println(Arrays.toString(ints1));

    }

    public int[] sortedSquares(int[] nums) {
        int size = nums.length;
        int[] newArray = new int[size];
        int left = 0;
        int index = size - 1;
        int right = size - 1;
        while (left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                newArray[index--] = nums[left] * nums[left];
                left++;
            } else {
                newArray[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return newArray;
    }
}
