package com.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 判断链表里是否有环
 */
public class hasCycle {

    public static void main(String[] args) {

    }

    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null){
            if(set.contains(node)){
                return true;
            } else {
                set.add(node);
                node = node.next;
            }
        }
        return false;
    }
}
