package com.LeetCode;

public class reverseList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        l1.next = l2;
        ListNode listNode = reverseList1(l1);
    }

    /**
     * 反转链表递归
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        if (head.next == null) {
            return head;
        }
        //先将该结点的下一个结点保存
        //也可以不保存
        //head.next.next = head;//这一句就可以搞定
        ListNode reverseList = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        //这样就可以保证最后返回的就是反转以后链表的头节点
        //返回的值不参与递归处理，仅作为返回值处理
        return reverseList;
    }

    /**
     * 用迭代来反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode temp;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
