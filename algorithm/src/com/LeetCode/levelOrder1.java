package com.LeetCode;
/**
 * 实现对二叉树的层序遍历
 */

import java.util.*;

public class levelOrder1 {
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
        TreeNode treeNode11 = new TreeNode(4);
        treeNode8.left = treeNode9;


        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.right = treeNode5;
        treeNode2.right = treeNode6;
        treeNode3.left = treeNode7;

        levelOrder1 levelOrder1 = new levelOrder1();
        List<List<Integer>> lists = levelOrder1.levelOrder01(treeNode1);
        System.out.println(lists);
    }

    /**
     * 方法一，使用lever值来保存层数，用list保存
     *
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        levelOrder(root, 1, lists);
        return lists;
    }

    public void levelOrder(TreeNode root, int level, List<List<Integer>> lists) {
        if (lists.size() < level) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.val);
            lists.add(arrayList);
        } else {
            lists.get(level - 1).add(root.val);
        }
        if (root.left != null) {
            levelOrder(root.left, level + 1, lists);
        }
        if (root.right != null) {
            levelOrder(root.right, level + 1, lists);
        }

    }

    /**
     * 方法二，使用队列来实现对二叉树的BFS(广度优先遍历)
     *
     * @param root
     * @return
     */

    public List<List<Integer>> levelOrder01(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        if (root == null) {
            return lists;
        }
        nodes.add(root);
        while (nodes.size() > 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            int n = nodes.size();
            while (n > 0) {
                root = nodes.poll();
                arrayList.add(root.val);
                n--;
                if (root.left != null) {
                    nodes.add(root.left);
                }
                if (root.right != null) {
                    nodes.add(root.right);
                }
            }
            lists.add(arrayList);
        }
        return lists;
    }
}
