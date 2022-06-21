package com.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder01 {



    public int[] levelOrder1(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            while (n > 0){
                TreeNode node = queue.poll();
                list.add(node);
                if(node.left != null)queue.add(node.left);
                if(node.right != null)queue.add(node.right);
                n--;
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i).val;
        }
        return ints;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> integerList = new ArrayList<>();
            while (n > 0){
                TreeNode node = queue.poll();
                integerList.add(node.val);
                if(flag) {
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                } else {
                    if (node.right != null) queue.add(node.right);
                    if (node.left != null) queue.add(node.left);
                }
                n--;
            }
            list.add(integerList);
            flag = !flag;
        }
        return list;
    }


}
