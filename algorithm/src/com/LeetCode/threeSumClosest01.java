package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumClosest01 {
    public static void main(String[] args) {
        threeSumClosest01 closest01 = new threeSumClosest01();
        int[] array = {1,2,4,8,16,32,64,128};
        int i = closest01.threeSum(array, 82);
        System.out.println(i);
    }



    public int threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        int size = nums.length;
        int min = Integer.MAX_VALUE;
        for (int first = 0; first < size; first++) {
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int start = first + 1;
            int end = size - 1;
            while (start < end){
                int gap = nums[first] + nums[start] + nums[end] - target;
                if(Math.abs(gap) < Math.abs(min)){
                    min = gap;
                } else if (gap > 0){
                    end--;
                } else {
                    start++;
                }
            }
        }
        return target + min;
    }
}