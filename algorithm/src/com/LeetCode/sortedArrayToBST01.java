package com.LeetCode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class sortedArrayToBST01 {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        Arrays.sort(array);
        sortedArrayToBST01 sortedArrayToBST01 = new sortedArrayToBST01();
        TreeNode treeNode = sortedArrayToBST01.sortedArrayToBST1(array);
    }

    public TreeNode sortedArrayToBST1(int[] nums) {
        int mid = nums.length / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        int i = mid + 1;
        int j = mid - 1;
        while(true){
            if(i < nums.length){
                add(nums[i], treeNode);
                ++i;
            }
            if(j >= 0){
                add(nums[j], treeNode);
                --j;
            }
            if(i == nums.length && j < 0){
                break;
            }
        }
        return treeNode;
    }

    public void add(int num, TreeNode node) {
        if (node == null) {
            return;
        }
        if (num > node.val) {
            if (node.right == null) {
                node.right = new TreeNode(num);
            } else {
                add(num, node.right);
            }
        } else {
            if (node.left == null) {
                node.left = new TreeNode(num);
            } else {
                add(num, node.left);
            }
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return sortedArrayToBST(0, nums.length - 1, nums);
    }

    public TreeNode sortedArrayToBST(int left, int right,int[] nums) {
        if(left > right){
            return null;
        }

        int mid = (right + left) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(left, mid+1 , nums);
        treeNode.right = sortedArrayToBST(mid + 1, right, nums);
        return treeNode;
    }

}
