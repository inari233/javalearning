package com.LinkedList;

import java.util.Stack;

public class LinkedList {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node = new HeroNode(1);
        HeroNode node1 = new HeroNode(2);
        HeroNode node2 = new HeroNode(3);
        HeroNode node3 = new HeroNode(4);
        HeroNode node5 = new HeroNode(5);
        HeroNode node6 = new HeroNode(6);
        HeroNode node7 = new HeroNode(7);
        singleLinkedList.add(node);
        singleLinkedList.add(node1);
        singleLinkedList.add(node2);
        singleLinkedList.add(node3);
        singleLinkedList.headAdd(node5);
        singleLinkedList.headAdd(node6);
        singleLinkedList.showList();
        //singleLinkedList.reserve();
        System.out.println("已反转");
        //singleLinkedList.reverseShow(singleLinkedList.headNode.next);
        singleLinkedList.reverseShow2(singleLinkedList.headNode.next);

    }

}


class SingleLinkedList{
    public HeroNode headNode = new HeroNode(0);

    public void add(HeroNode heroNode){
        //需要一个辅助节点
        HeroNode node = headNode;
        while (true){
            if(node.next == null){
                node.next = heroNode;
                break;
            }
            node = node.next;
        }
    }

    public void reserve(){
        HeroNode node = headNode.next;
        HeroNode next;
        SingleLinkedList singleLinkedList1 = new SingleLinkedList();
        do {
            next = node.next;
            singleLinkedList1.headAdd(node);
            node = next;
        } while (node != null);
        this.headNode = singleLinkedList1.headNode;
    }

    public void reverseShow(HeroNode node){
        if(node.next != null){
            reverseShow2(node.next);
        }
        System.out.println(node.data);
    }

    public void reverseShow2(HeroNode node){
        Stack<HeroNode> heroNodes = new Stack<>();
        while (node != null){
            heroNodes.push(node);
            node = node.next;
        }
        while (heroNodes.size() > 0){
            System.out.println(heroNodes.pop());
        }
    }


    public void insert(int index, HeroNode heroNode){
        HeroNode node = headNode;
        if(headNode.next == null){
            headNode.next = heroNode;
            heroNode = null;
            return;
        }
        int i = 0;
        while (i < index && node.next != null){
            node = node.next;
            ++i;
        }
        if(i < index){
            throw new RuntimeException("你要找的位置不存在");
        }
        if(node.next != null) {
            heroNode.next = node.next;
            node.next = heroNode;
        } else {
            node.next = heroNode;
            heroNode.next = null;
        }
    }

    public void headAdd(HeroNode heroNode){
        HeroNode node = heroNode;
        if(headNode.next == null){
            headNode.next = node;
            node.next = null;
            return;
        }
        heroNode.next = headNode.next;
        headNode.next = heroNode;
    }

    public int delete(int index){
        HeroNode node = headNode;
        int i = 0;
        while (i < index && node.next != null){
            node = node.next;
            ++i;
        }
        if(i < index){
            throw new RuntimeException("你要找的节点位置超出链表的总长度");
        }
        HeroNode next = node.next;
        node.next = node.next.next;
        return next.data;
    }

    public void showList(){
        HeroNode node = headNode;
        if(headNode.next == null){
            System.out.println("列表为空");
            return;
        }
        while (true){
            if (node.next == null){
                System.out.println("遍历完毕");
                break;
            }
            node = node.next;
            System.out.println(node);
        }
    }


}

class HeroNode{
    public int data;
    public HeroNode next;

    public HeroNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " ";
    }
}

