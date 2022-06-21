package com.LeetCode;

import java.util.HashMap;

public class buildTree01 {
    HashMap<Integer, Integer> map;

    public static void main(String[] args) {

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inOrderStart, int inOrderEnd) {

        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        //前序遍历中第一个值就是根节点，用hashmap来找到该变量在中序遍历数组里的下标
        int index = map.get(rootVal);
        //中序遍历左边的个数就是左子树的个数
        int leftSize = index - inOrderStart;
        TreeNode root = new TreeNode(rootVal);

        //画图进行理解,递归构造左右结点
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize,
                inorder, inOrderStart, index - 1);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inOrderEnd);
        return root;
    }


}


class buildTree02 {
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int index = map.get(rootVal);
        int size = index = inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(inorder, inStart, index - 1,
                postorder, postStart, postStart + size - 1);
        root.right = buildTree(inorder, index + 1, inEnd,
                postorder, postStart + size, postEnd);
        return root;
    }

}

class buildTree03 {
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int perStart, int perEnd,
                              int[] postorder, int postStart, int postEnd) {

        if (perStart > perEnd) {
            return null;
        }
        if (perEnd == perStart) {
            return new TreeNode(preorder[perStart]);
        }

        int rootVal = preorder[perStart];
        int leftRootVal = preorder[perStart + 1];
        int index = map.get(leftRootVal);
        int size = index - postStart + 1;

        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(preorder, perStart + 1, perStart + size,
                postorder, postStart, index);
        root.right = buildTree(preorder, perStart + size + 1, perEnd,
                postorder, index + 1, postEnd - 1);

        return root;
    }

}
