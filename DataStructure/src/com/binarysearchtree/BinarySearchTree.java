package com.binarysearchtree;

public class BinarySearchTree {
    public node head;

    public node search(int value){
        if (head == null){
            return null;
        } else {
            return head.search(value);
        }
    }

    public node parent(int value){
        if (head == null){
            return null;
        } else {
            return head.parent(value);
        }
    }

    public void delete(int value){
        if (head == null){
            return;
        } else {
            head.delete(value);
        }
    }

    public void add(node node){
        if (head == null){
            head = node;
        } else {
            head.add(node);
        }
    }
    public void infixOrder(){
        if(head == null){
            return;
        }
        infixOrder(head);
    }

    public void infixOrder(node node){
        if(node == null){
            return;
        }

        if(node.left != null){
            infixOrder(node.left);
        }
        System.out.print(node.value + "\t");
        if(node.right != null){
            infixOrder(node.right);
        }
    }

}
