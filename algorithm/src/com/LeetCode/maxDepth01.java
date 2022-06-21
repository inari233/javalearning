package com.LeetCode;

public class maxDepth01 {
    boolean flag = true;


    public boolean isBalanced(TreeNode root) {
        if(MaxDepth(root) == -1){
            return false;
        }
        return true;
    }

    public int MaxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
    }


}
