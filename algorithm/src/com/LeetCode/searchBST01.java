package com.LeetCode;

public class searchBST01 {
    public static void main(String[] args) {

    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(val == root.val){
            return root;
        }
        if(val > root.val){
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }
}
