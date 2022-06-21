package com.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class pathSum01 {
    List<List<Integer>> list = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return list;
    }

    public void dfs(TreeNode root, int target) {
        if(root == null){
            return;
        }
        path.offerLast(root.val);
        target -= root.val;
        if(root.left == null && root.right == null && target == 0){
            list.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }

}
