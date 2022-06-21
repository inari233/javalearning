package com.LeetCode;

public class numWays01 {

    public static void main(String[] args) {
        numWays01 numWays01 = new numWays01();
        int i = numWays01.numWays(44);
        System.out.println(i);
    }
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if(i == 0 || i == 1){
                dp[i] = 1;
                continue;
            }
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
