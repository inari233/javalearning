package com.binarysearchtree;

public class BST {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        int[] array = {7, 3, 10, 12, 5, 1, 9};
        for (int i : array) {
            binarySearchTree.add(new node(i));
        }
        binarySearchTree.add(new node(2));
        binarySearchTree.delete(3);
        binarySearchTree.infixOrder();
    }
}


