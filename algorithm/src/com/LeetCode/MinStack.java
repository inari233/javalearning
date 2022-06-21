package com.LeetCode;

import java.util.Stack;


class MinStack {
    public Stack<Node12> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(!stack.isEmpty()){
            stack.push(new Node12(x, x));
        } else {
            if(x < stack.peek().min){
                stack.push(new Node12(x, x));
            } else {
                stack.push(new Node12(x, stack.peek().min));
            }
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek().val;
    }

    public int min() {
        return stack.peek().min;
    }
}


class Node12 {
    public int val;
    public int min;

    public Node12(int val, int min) {
        this.val = val;
        this.min = min;
    }
}