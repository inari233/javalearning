package com.LeetCode;


public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(-1);
        ListNode temp = new ListNode(-1);
        ListNode endNode = newList;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp = list1;
                list1 = list1.next;
                endNode.next = temp;
                endNode = endNode.next;
                endNode.next = null;
            } else {
                temp = list2;
                list2 = list2.next;
                endNode.next = temp;
                endNode = endNode.next;
                endNode.next = null;
            }
        }
        if (list1 != null) {
            endNode.next = list1;
        }

        if (list2 != null) {
            endNode.next = list2;
        }
        return newList.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoLists1(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists1(list1, list2.next);
            return list2;
        }
    }



}





class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}
