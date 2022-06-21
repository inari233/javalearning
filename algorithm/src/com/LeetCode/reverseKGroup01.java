package com.LeetCode;

public class reverseKGroup01 {
    public static void main(String[] args) {

    }


    public ListNode reverseKGroup(ListNode head, int k){
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if(b == null)return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }



    public ListNode reverse(ListNode a, ListNode b){
        ListNode curr = a;
        ListNode prev = null;
        ListNode next;
        while (curr != b){
             next = curr.next;
             curr.next = prev;
             prev = curr;
             curr = next;
        }
        return prev;
    }


}
