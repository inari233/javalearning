package com.LeetCode;

public class search01 {
    public static void main(String[] args) {
        int[] array = {1,0,3,5,9,12};
        search01 search01 = new search01();
        int search = search01.search(array, 12);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
