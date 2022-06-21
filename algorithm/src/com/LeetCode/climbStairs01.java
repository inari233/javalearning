package com.LeetCode;

import java.util.Arrays;

/**
 * 爬楼梯问题
 */
public class climbStairs01 {
    public int ways;


    public static void main(String[] args) {
        climbStairs01 climbStairs01 = new climbStairs01();
        int i = climbStairs01.climbStairs(45);
        System.out.println(i);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, -666);
        return findWay(n,dp);
    }

    public int findWay(int n, int[] dp){
        if(n == 1 || n == 2){
            return n;
        }

        if(dp[n] != -666){
            return dp[n];
        }
        dp[n] = findWay(n - 1, dp) + findWay(n - 2, dp);
        return dp[n];
    }
}
