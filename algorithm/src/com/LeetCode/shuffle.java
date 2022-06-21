package com.LeetCode;

import java.util.Arrays;
import java.util.Random;

public class shuffle {
    public static void main(String[] args) {

    }


}

class Solution {
public int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if(nums.length == 0){
            return null;
        }

        int[]a = nums.clone();
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i + 1);
            swap(a, j, i);
        }
        return a;
    }

    private void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */