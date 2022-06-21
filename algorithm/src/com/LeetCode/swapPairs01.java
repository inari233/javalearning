package com.LeetCode;

import java.util.List;

public class swapPairs01 {
    ListNode nextNode = null;

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node.next = node1;
        swapPairs01 swap = new swapPairs01();
        ListNode newNode = swap.reverseListRange(node,2, 3);
        System.out.println(newNode.val);
    }


    public ListNode swapPairs (ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        return swapPairsRecursion(head, 1);
    }


    public ListNode swapPairsRecursionPlus(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsRecursionPlus(newHead.next);
        newHead.next = head;
        return newHead;
    }





    public ListNode swapPairsRecursion(ListNode head, int n){
        if(head.next.next == null){
            if(n % 2 == 0){
                return head.next;
            }
            head.next.next = head;
            ListNode p = head.next;
            head.next = null;
            return p;
        }
        ListNode node = swapPairsRecursion(head.next, n + 1);
        if(n % 2 == 1){
            ListNode p = head.next;
            head.next.next = head;
            head.next = node;
            return p;
        }
        return node;
    }



    public ListNode swapPairs1(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode prev = null;
        ListNode newHead = head;
        if(head.next != null) {
            newHead = head.next;
        }
        while (p != null && p.next != null){
            ListNode next = p.next.next;
            p.next.next = p;
            if (prev != null) {
                prev.next = p.next;
            }
            prev = p;
            p.next = next;
            p = next;
        }
        return newHead;
    }

    public ListNode reverseList(ListNode node){
        if(node.next == null){
            return node;
        }
        ListNode last = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    public ListNode reverseListFront(ListNode node, int n){
        if(n == 1 || node.next == null){
            nextNode = node.next;
            return node;
        }
        ListNode late = reverseListFront(node.next, n - 1);
        node.next.next = node;
        node.next = nextNode;
        return late;
    }


    public ListNode reverseListRange(ListNode head, int m, int n){
        if(m == 1){
            return reverseListFront(head, n);
        }
        head.next = reverseListRange(head.next, m- 1, n - 1);
        return head;
    }



}
