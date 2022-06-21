package com.LeetCode;

/**
 * 删除链表的倒数第n个结点
 */
public class removeNthFromEnd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        l1.next = l2;
        ListNode listNode = removeNthFromEnd2(l2, 2);
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode node = head;
        ListNode temp;
        int t = n;
        boolean flag = false;
        while (node.next != null) {
            temp = node;
            while (t > 0) {
                if (temp.next == null) {
                    flag = true;
                    break;
                }
                temp = temp.next;
                t--;
            }
            if (temp.next == null) {
                break;
            } else {
                t = n;
                node = node.next;
            }
        }
        if (flag) {
            return head.next;
        }
        if (node.next != null) {
            node.next = node.next.next;
        } else {
            node = null;
            return null;
        }
        return head;
    }

    /*
    使用快慢指针，只要第一个指针比第二份指针前n个，这样就可以
    保证第二个指针指向空时，第一个指针指向要删除的结点的前一个结点
     */

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        boolean flag = false;
        while(n > 0) {
            if(second.next == null){
                flag = true;
                return head.next;
            }
            second = second.next;
            n--;
        }
        while (second.next != null){
            first = first.next;
            second = second.next;
        }
        if(first.next != null) {
            first.next = first.next.next;
        }
        return head;
    }
}
