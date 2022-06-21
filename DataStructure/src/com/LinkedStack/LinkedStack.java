package com.LinkedStack;

public class LinkedStack {
    public static void main(String[] args) {

    }
}


class LinkedStackUse{
    public Node head = new Node(0);

    public void add(Node data){
        Node node = head;
        if(node.next == null){
            node.next = data;
        }

        data.next = node.next;
        node.next = data;
    }


    public int pop(){
        if(head.next == null){
            throw new RuntimeException("栈空");
        }

        int value = head.next.data;
        head.next = head.next.next;
        return value;
    }

}

class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }


}
