package com.LeetCode;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到数组里的最大连续子序列
 */
public class MaximumSubarray{
    public static void main(String[] args) {
        int[] nums = {0};
        int i = maxSubArray(nums);
        System.out.println(i);
    }


    public static int maxSubArray(int[] nums){
        int max = nums[0];
        int sum = 0;
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < nums.length - i; k++) {
                t = k;
                sum = 0;
                while (t <= k + i){
                    sum += nums[t];
                    t++;
                }
                if (sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
}
