package com.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class containsduplicate {
    public static void main(String[] args) {

    }


    /**
     * 方法一，使用set
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.contains(num)){
                set.add(num);
            } else {
                return true;
            }
        }
        return false;
    }
    /**
     * 方法二使用先排序在比较，使用双指针
     */


}
