package com.LeetCode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1};
        moveZeroes1(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes1(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if(num != 0){
                nums[i++] = num;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
