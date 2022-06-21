package com.LeetCode;

import java.util.Stack;

public class CQueue {
    public Stack<Integer> mainStack;
    public Stack<Integer> assistantStack;

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
    }

    public CQueue() {
        mainStack = new Stack<>();
        assistantStack = new Stack<>();
    }

    public void appendTail(int value) {
        while (!mainStack.isEmpty()) {
            assistantStack.push(mainStack.pop());
        }
        mainStack.add(value);
        while (!assistantStack.isEmpty()) {
            mainStack.push(assistantStack.pop());
        }
    }

    public int deleteHead() {
        if (!mainStack.isEmpty()) {
            return mainStack.pop();
        }
        return -1;
    }
}
