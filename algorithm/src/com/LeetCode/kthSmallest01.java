package com.LeetCode;

public class kthSmallest01 {
    int res, k;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        if(--k == 0){
            res = root.val;
            return;
        }
        dfs(root.right);
    }
}
