package com.huffmantree;

import java.util.ArrayList;
import java.util.Comparator;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        ArrayList<node> nodes = new ArrayList<>();
        for (int i : array) {
            nodes.add(new node(i));
        }
        while (nodes.size() > 1){
            nodes.sort(new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    return o1.value - o2.value;
                }
            });

            node node1 = nodes.get(0);
            node node2 = nodes.get(1);
            node node3 = new node(node1.value + node2.value);
            node3.left = node1;
            node3.right = node2;
            nodes.remove(node1);
            nodes.remove(node2);
            nodes.add(node3);
        }
        node.preOrder(nodes.get(0));
    }
}

class node implements Comparable<node>{
    public int value;
    public char c;
    public node left;
    public node right;

    public node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(node o) {
        return this.value - o.value;
    }

    public static void preOrder(node node){
        if(node == null){
            return;
        }
        System.out.println(node.value);
        if(node.left != null){
            preOrder(node.left);
        }
        if(node.right != null){
            preOrder(node.right);
        }
    }
}
