package com.ArrayStack;

public class ArrayStack {
    public static void main(String[] args) {
        ArrayStackUse arrayStackUse = new ArrayStackUse(5);
        arrayStackUse.push(2);
        arrayStackUse.push(3);
        arrayStackUse.push(4);
        arrayStackUse.push(8);
        arrayStackUse.push(5);
        arrayStackUse.showStack();

    }
}


class ArrayStackUse{
    public int MaxSize;
    public int[] stack;
    public int top = -1;

    public ArrayStackUse(int maxSize) {
        MaxSize = maxSize;
        stack = new int[MaxSize];
    }

    public boolean isFull(){
        return top == MaxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("栈慢");
            return;
        }

        stack[++top] = value;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }

        return stack[top--];
    }


    public void showStack(){
        if(isEmpty()){
            System.out.println("栈空");
            return;
        }
        int t = top;
        while (t != -1){
            System.out.println(stack[t--]);
        }
    }
}
