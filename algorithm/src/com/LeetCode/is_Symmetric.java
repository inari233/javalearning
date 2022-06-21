package com.LeetCode;

public class is_Symmetric {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(3);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(4);


        TreeNode treeNode8 = new TreeNode(1);
        TreeNode treeNode9 = new TreeNode(2);
        TreeNode treeNode10 = new TreeNode(3);
        TreeNode treeNode11= new TreeNode(4);
        treeNode8.left = treeNode9;


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode2.right = treeNode6;
        treeNode3.left = treeNode7;
        is_Symmetric is_symmetric = new is_Symmetric();
        boolean symmetric = is_symmetric.isSymmetric(treeNode1);
        System.out.println(symmetric);

    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val&& isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
