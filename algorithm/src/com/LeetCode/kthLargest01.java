package com.LeetCode;

/**
 * 二叉搜索树的中序遍历为递增序列
 */
public class kthLargest01 {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.right);
        if(--k == 0){
            res = root.val;
            return;
        }
        dfs(root.left);
    }
}
