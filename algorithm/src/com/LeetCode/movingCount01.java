package com.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class movingCount01 {
    public static void main(String[] args) {
        movingCount01 movingCount01 = new movingCount01();
        int i = movingCount01.movingCount(20, 23, 8);
        System.out.println(i);

    }


    /**
     * 用值来表示状态
     * 0表示不可访问
     * 1表示未访问
     * 2表示已经访问过了
     */
    public int movingCount(int m, int n, int k) {
        int[][] map = new int[m + 2][n + 2];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = 1;
            }
        }
        Queue<Integer[]> queue = new LinkedList<>();
        int count = 1;
        queue.add(new Integer[]{1, 1});
        map[1][1] = 2;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Integer[] array = queue.poll();
                size--;
                int i = array[0];
                int j = array[1];
                if (map[i + 1][j] == 1 && isArea(i + 1, j, k, map)) {
                    queue.add(new Integer[]{i + 1, j});
                    map[i + 1][j] = 2;
                    count++;
                }
                if (map[i - 1][j] == 1 && isArea(i - 1, j, k, map)) {
                    queue.add(new Integer[]{i - 1, j});
                    map[i - 1][j] = 2;
                    count++;
                }
                if (map[i][j + 1] == 1 && isArea(i, j + 1, k, map)) {
                    queue.add(new Integer[]{i, j + 1});
                    map[i][j + 1] = 2;
                    count++;
                }
                if (map[i][j - 1] == 1 && isArea(i, j - 1, k, map)) {
                    queue.add(new Integer[]{i, j - 1});
                    map[i][j - 1] = 2;
                    count++;
                }
            }
        }


        return count;
    }

    public boolean isArea(int i, int j, int k, int[][] map) {
        if (map[i][j] == 0) {
            return false;
        }
        i -= 1;
        j -= 1;
        int sum = 0;
        while (i > 0) {
            int digit = i % 10;
            sum += digit;
            i = i / 10;
        }
        while (j > 0) {
            int digit = j % 10;
            sum += digit;
            j = j / 10;
        }
        return sum <= k;
    }
}
