package com.LeetCode;

import java.util.Arrays;

public class NumArray {
    int[] array;
    int[][] dp;
    public NumArray(int[] nums) {
        array = nums;
        calculate();
    }

    public static void main(String[] args) {

    }
    public int sumRange(int left, int right) {
        return dp[left][right];
    }


    /**
     * dp[i][j]
     * dp[i][j]表示数组从索引i开始，到j的和
     * dp[i][j] = dp[i-1][j-1] + nums[j] - numd[i]
     * 边界条件dp[0][0] = nums[0]
     */
    public void calculate() {
        dp = new int[array.length][array.length ];
        for (int i = 1; i <= array.length; i++) {
            for (int j = i; j <= array.length; j++) {
                if (i == j) {
                    dp[i][j] = array[i];
                }
                dp[i][j] = dp[i][j] + array[j];
            }
        }
    }
}
