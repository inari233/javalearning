package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 返回三数之和为零的三个数
 */
public class threeSum01 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length;
        for (int begin = 0; begin < size; begin++) {
            if (begin > 0 && nums[begin] == nums[begin - 1]) {
                continue;
            }
            int target = -nums[begin];
            int end = size - 1;
            for (int start = begin + 1; start < size; start++) {
                if (start > begin + 1 && nums[start] == nums[start - 1]) {
                    continue;
                }
                while (end > start && (nums[start] + nums[end]) > target) {
                    end--;
                }
                if (start == end) {
                    break;
                }
                if (target == nums[end] + nums[start]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[begin]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int begin = 0; begin < size; begin++) {
            if (begin > 0 && nums[begin] == nums[begin - 1]) {
                continue;
            }
            int target = -nums[begin];
            int end = size - 1;
            int start = begin + 1;
            while (start < end) {
                if (target == nums[end] + nums[start]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[begin]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    ans.add(list);
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end - 1]) {
                        end--;
                    }
                    start++;
                    end--;
                } else if (target > nums[end] + nums[start]) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return ans;
    }


}
