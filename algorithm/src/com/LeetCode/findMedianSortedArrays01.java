package com.LeetCode;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 */
public class findMedianSortedArrays01 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        findMedianSortedArrays01 find = new findMedianSortedArrays01();
        double medianSortedArrays = find.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        int[] t = new int[nums1.length + nums2.length];
        int index = 0;
        while (l < nums1.length && r < nums2.length){
            if(nums1[l] < nums2[r]){
                t[index++] = nums1[l++];
            } else {
                t[index++] = nums2[r++];
            }
        }
        while (l < nums1.length){
            t[index++] = nums1[l++];
        }
        while (r < nums2.length){
            t[index++] = nums2[r++];
        }
        if(index % 2 == 0){
            return (t[index/2] + t[index/2-1])/2.0;
        } else {
            return t[index/2];
        }

    }

    /**
     * 使用二分查找找到中位线
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return 中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;  //中位线
        int left = 0;
        int right = m;
        //当left == right时退出，说明找到了该分界线
        while (left < right){
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            //因为在二分的时候加上了1，所以i - 1不会越界
            if(nums1[i - 1] > nums2[j]){//说明第一个数组左边多了
                right = i - 1;
            } else {
                left = i;//在二分中如果这样写就会在[left, right]这种数组一直循环下去，所以在二分的时候加1
            }
        }

        int i = left;
        int j = totalLeft - i;
        int num1max = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int num1min = i == m ? Integer.MAX_VALUE : nums1[i];
        int num2max = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int num2min = j == n ? Integer.MAX_VALUE : nums2[j];

        if((m + n) % 2 == 0){
            return (Math.max(num1max, num2max) + Math.min(num1min, num2min)) / 2.0;
        } else {
            return Math.max(num1max, num2max);
        }


    }


}
