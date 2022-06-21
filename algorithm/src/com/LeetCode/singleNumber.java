package com.LeetCode;

import java.util.Arrays;

public class singleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 2, 5, 5, 6, 6, 4};
        int i = singleNumber1(nums);
        System.out.println(i);
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * @param nums 运算的数组
     * @return 返回的只出现过一次的值
     */

    /**
     * 方法一，老办法先排序再判断
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums){
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        while(j < nums.length){
            while (nums[i] == nums[j]){
                ++j;
            }
            if(j - i == 1){
                return nums[i];

            }
            i = j;
            j++;
        }
        return nums[j - 1];
    }

    /**
     * 方法二使用set集合
     */


    /**
     * 方法三使用位运算a^a=0,0^a=a
     * 且a^b^a = a^a^b满足交换律
     */

    public int singleNumber(int[] nums) {
        int reduce = 0;
        for (int num : nums) {
            reduce =  reduce ^ num;
        }
        return reduce;
    }

}
