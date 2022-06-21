package com.LeetCode;

/**
 * 判断链表是否是回文链表
 */
public class isPalindromevalid {
    public static void main(String[] args) {

    }


    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针找中间结点
        //因为快指针一次跳两步，而慢指针一次只跳一步
        //所以等快指针到达尾部的时候，慢指针正好到达中间
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //说明链表的长度是奇数个
        if(fast != null){
            slow = slow.next;
        }
        //将后半链表倒装，这样就可以一个一个进行比较
        slow = reverse(slow);
        fast = head;
        while(slow != null){
            if(fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;

    }


    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode temp;
        while (head.next != null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
