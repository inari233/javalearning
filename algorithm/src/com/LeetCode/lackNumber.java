package com.LeetCode;

import java.util.Arrays;

public class lackNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        lackNumber lackNumber = new lackNumber();
        int i = lackNumber.missingNumber(nums);
        System.out.println(i);
    }

    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i != nums[i]){
                return i;
            }
        }
        return nums.length;
    }

    public int missingNumber(int[] nums){
        int sum = (nums.length) * (nums.length + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
