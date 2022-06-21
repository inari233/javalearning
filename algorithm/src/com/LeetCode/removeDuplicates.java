package com.LeetCode;

/**
 * 删除数组中相同的元素，数组是有序的
 * 最后把不相同的数组个数放回，并放在数组的前k个中
 */
public class removeDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int i = RemoveDuplicates(nums);
        System.out.println(i);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


    public static int RemoveDuplicates(int[] nums) {
        int j = 1;
        int i = 0;
        while (j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
