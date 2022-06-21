package com.queue;


class Test {
    public static void main(String[] args) {
        ArrayQueue_ queue_ = new ArrayQueue_();
        int[] queue = queue_.getQueue();
        
    }
}

public class ArrayQueue_ {
    public static final int MAXSIZE = 100;
    public int[] queue = new int[MAXSIZE - 1];
    public int front = -1;
    public int rear = -1;

    public void addQueue(int num) {
        if (rear == MAXSIZE - 1) {
            throw new RuntimeException("队列已满");

        }

        queue[++rear] = num;
    }

    public void deleteQueue() {
        if (front == rear) {
            throw new RuntimeException("队列为空");
        }
        queue[++front] = 0;
    }

    public boolean IsFull() {
        return (rear == MAXSIZE - 1);
    }

    public boolean IfEmpty(){
        return (rear == front);
    }


    public int[] getQueue() {
        return queue;
    }

    public void setQueue(int[] queue) {
        this.queue = queue;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }
}


