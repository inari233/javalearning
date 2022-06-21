package com.LeetCode;

import java.util.PriorityQueue;

public class mergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> listNodes = new PriorityQueue<ListNode>(lists.length, (a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        for (ListNode head : lists) {
            if(head != null){
                listNodes.add(head);
            }
        }
        while (!listNodes.isEmpty()){
            ListNode node = listNodes.poll();
            if(node.next != null) {
                listNodes.add(node.next);
            }
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }
}
