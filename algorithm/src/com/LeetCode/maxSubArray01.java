package com.LeetCode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 */
public class maxSubArray01 {

    public static void main(String[] args) {
        maxSubArray01 max = new maxSubArray01();
        int[] array = {-1, -2};
        int i = max.maxSubArray(array);
        System.out.println(i);
    }

    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int index = 1;
        int max = nums[0];
        for (int i = 1;  i < n ; i++) {
            dp[index] = Math.max(nums[i], dp[index - 1] + nums[i]);
            max = Math.max(max, dp[index]);
            index++;
        }
        return max ;
    }


    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}
