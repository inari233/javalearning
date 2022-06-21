package com.LeetCode;

import java.util.Arrays;

/**
 * 买卖股票的最佳时机
 */
public class maxProfit01 {
    public static void main(String[] args) {

    }


    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public int maxProfit1(int[] prices){
        int size = prices.length;
        int[][] dp = new int[size][2];
        for (int i = 0; i < size; i++) {
            if(i == 0){
                dp[0][0] = 0;
                dp[0][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

}
