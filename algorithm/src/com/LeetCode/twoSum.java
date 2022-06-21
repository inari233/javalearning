package com.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 */
public class twoSum {
    public static void main(String[] args) {
        int[] ints = {3, 2, 4};
        int[] ints1 = twoSum2(ints, 6);
        for (int i : ints1) {
            System.out.println(i);
        }

    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] ints = new int[2];
        int index = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(target - num, index++);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null && map.get(nums[i]) != i) {
                ints[0] = i;
                ints[1] = map.get(nums[i]);
                break;
            }
        }
        return ints;
    }


    public int[] twoSum1(int[] numbers, int target) {
        int[] array = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (start > 0 && numbers[start] == numbers[start - 1]) {
                start++;
                continue;
            }
            if (numbers[start] + numbers[end] == target) {
                array[0] = start;
                array[1] = end;
            } else if (numbers[start] + numbers[end] > target){
                end--;
            } else {
                start++;
            }
        }
        return array;
    }


    public int[] twoSum3(int[] numbers, int target){
        int[] array = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end){
            if(start > 0 && numbers[start] == numbers[start - 1])continue;
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                array[0] = start;
                array[1] = end;
                break;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return array;
    }


}
