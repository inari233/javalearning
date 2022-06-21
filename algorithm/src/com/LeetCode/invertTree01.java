package com.LeetCode;

public class invertTree01 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invert(root.left);
        invert(root.right);

    }
}
