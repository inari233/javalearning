package com.LeetCode;

public class deleteNode {
    public static void main(String[] args) {

    }

    public void deleteNode1(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }

}

