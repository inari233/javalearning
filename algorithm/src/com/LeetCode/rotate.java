package com.LeetCode;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
public class rotate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        rotateArray2(nums, 1);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    /**
     *方法一使用临时数组
     * @param nums
     * @param k
     */
    public static void rotateArray1(int[] nums, int k) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i + k) % nums.length] = newArray[i];
        }

    }


    /**
     * 方法二，反转数组，将所有数组的数据反转，再反转前k个，最后反转后k个
     * 画图来理解
     */
    public static void rotateArray2(int[] nums, int k){
        k %= nums.length;
        revere(nums, 0, nums.length - 1);
        revere(nums, 0, k -1 );
        revere(nums, k, nums.length - 1);
    }

    public static void revere(int[] array, int begin, int end){
        int temp;
        while (end > begin){
            temp = array[end];
            array[end] = array[begin];
            array[begin] = temp;
            ++begin;
            --end;
        }
    }
}
