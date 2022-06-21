package com.LeetCode;

public class addTwoNumbers01 {

    public static void main(String[] args) {
        addTwoNumbers01 add = new addTwoNumbers01();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        ListNode node7 = new ListNode(9);
        ListNode node8 = new ListNode(9);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(9);
        ListNode node11 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;


        ListNode node = add.addTwoNumbers(node1, node11);

    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int i = number(l1) + number(l2);
        int n = new String(String.valueOf(i)).length();
        ListNode node = new ListNode(i % 10);
        ListNode prev = node;
        int digit;
        i = i / 10;
        while (i > 0) {
            digit = i % 10;
            prev.next = new ListNode(digit);
            prev = prev.next;
            i = i / 10;
        }
        return node;
    }

    public int number(ListNode node) {
        if (node.next == null) {
            return node.val;
        }
        return number(node.next) * 10 + node.val;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode node = newNode;
        while (l1 != null || l2 != null) {
            newNode.val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + newNode.val;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            ListNode node1 = new ListNode(newNode.val >= 10 ? 1 : 0);
            if(l1 == null && l2 == null && node1.val == 0){
                break;
            }
            if (newNode.val >= 10) {
                newNode.val = newNode.val - 10;
            }
            newNode.next = node1;
            newNode = node1;
        }
        return node;
    }


}
