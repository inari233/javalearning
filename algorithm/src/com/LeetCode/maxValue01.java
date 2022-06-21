package com.LeetCode;

import java.util.Arrays;

public class maxValue01 {
    public static void main(String[] args) {
        maxValue01 max = new maxValue01();
        int[][] array = {{1, 2, 5},
                {3, 2, 1}
                };
        int i = max.maxValue(array);
        System.out.println(i);
    }

    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        int[][] map = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                map[i + 1][j + 1] = grid[i][j];
            }
        }
        int max = 0;
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + map[i][j], dp[i][j - 1] + map[i][j]);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
