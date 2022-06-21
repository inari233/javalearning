package com.LeetCode;

public class isValidBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;

        boolean validBST1 = isValidBST1(treeNode);
        System.out.println(validBST1);

    }

    public static boolean isValidBST1(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left != null && root.left.val > root.val){
            return false;
        }
        if(root.right != null && root.right.val < root.val){
            return false;
        }
        if(!(root.left == null) && !isValidBST1(root.left)){
            return false;
        }
        if(!(root.right == null) && !isValidBST1(root.right)){
            return false;
        }
        return true;
    }


    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        if(min != null && root.val < min.val)return false;
        if(max != null && root.val > max.val)return false;
        return isValidBST(root.left,min, root) && isValidBST(root.right, root, max);
    }
}
