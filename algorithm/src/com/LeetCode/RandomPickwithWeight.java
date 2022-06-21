package com.LeetCode;

import java.util.Arrays;

public class RandomPickwithWeight {
    int[] preSum;
    int total;

    public RandomPickwithWeight(int[] w) {
        preSum = new int[w.length];
        preSum[0] = w[0];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
        total = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        int x = (int)(Math.random()* total) + 1;
        return binarySearch(x);
    }

    public int binarySearch(int target) {
        int low = 0, high = preSum.length - 1;
        while (low < high){
            int mid = low + (high - low) / 2;
            if(preSum[mid] == target){
                low = mid;
            } else if (preSum[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
