package com.LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class maxDistance01 {
    public static void main(String[] args) {

    }

    public int maxDistance(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] movies = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == N * N) {
            return -1;
        }
        int distance = -1;
        int n;
        int[] t;
        while (queue.size() > 0) {
            distance++;
            n = queue.size();
            while (n > 0) {
                n--;
                t = queue.poll();
                int x = t[0];
                int y = t[1];
                for (int[] movie : movies) {
                    int x2 = x + movie[0];
                    int y2 = y + movie[1];
                    if (isArea(x2, y2, grid) && grid[x2][y2] == 0) {
                        grid[x2][y2] = 2;
                        queue.add(new int[]{x2, y2});
                    }
                }
            }
        }
        return distance;

    }

    public boolean isArea(int i, int j, int[][] grid) {
        return i >=0 && j >=0 && i < grid.length && j < grid[0].length;
    }
}
