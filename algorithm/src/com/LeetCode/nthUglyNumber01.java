package com.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class nthUglyNumber01 {
    public static void main(String[] args) {
        nthUglyNumber01 number01 = new nthUglyNumber01();
        int i = number01.nthUglyNumber(1352);
        System.out.println(i);
    }


    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n1 = 2 * dp[a];
            int n2 = 3 * dp[b];
            int n3 = 5 * dp[c];
            dp[i] = Math.min(Math.min(n1, n2), n3);
            if(dp[i] == n1) a++;
            if(dp[i] == n2) b++;
            if(dp[i] == n3) c++;
        }
        return dp[n - 1];
    }
}
