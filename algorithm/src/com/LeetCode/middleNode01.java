package com.LeetCode;

public class middleNode01 {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next == null || fast == null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
