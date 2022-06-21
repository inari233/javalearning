package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum01 {
    public static void main(String[] args) {
        fourSum01 sum01 = new fourSum01();
        int[] array = {2,2,2,2,2};
        List<List<Integer>> lists = sum01.fourSum(array, 8);
        System.out.println(lists);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        int size = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int first = 0; first < size; first++) {
            if(first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            for (int second = first + 1; second < size; second++) {
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                int start = second + 1;
                int end = size - 1;
                while (start < end){
                    int sum = nums[first] + nums[second] + nums[start] + nums[end];
                    if(sum == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        lists.add(list);
                        while (start < end && nums[start] == nums[start + 1]){
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]){
                            end--;
                        }
                        start++;
                        end--;
                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return lists;
    }
}
