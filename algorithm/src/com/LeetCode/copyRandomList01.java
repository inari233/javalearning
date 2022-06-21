package com.LeetCode;

import java.util.HashMap;

public class copyRandomList01 {
    public static void main(String[] args) {

    }

    public Node1 copyRandomList(Node1 head) {
        if(head == null)return null;
        HashMap<Node1, Node1> map = new HashMap<>();
        Node1 curr = head;
        while (curr != null){
            map.put(curr, new Node1(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
