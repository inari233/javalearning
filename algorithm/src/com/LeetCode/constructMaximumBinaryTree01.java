package com.LeetCode;

public class constructMaximumBinaryTree01 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);

    }


    public TreeNode build(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if(nums[i] > maxVal){
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, left, maxVal - 1);
        root.right = build(nums, maxVal + 1, right);
        return root;
    }
}
