package com.queue;

public class CircleArrayQueue {
    public static void main(String[] args) {

    }
}

class CircleQueue {
    private int[] queue;
    private int MAXSIZE;
    private int front;
    private int rear;

    public CircleQueue(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
        queue = new int[MAXSIZE];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return ((rear - 1) % MAXSIZE) == front;
    }

    public int getSize() {
        return (rear - front + MAXSIZE) % MAXSIZE;
    }

    public void add(int e) {
        if (isFull()) {
            System.out.println("队列已满");

        }
        queue[rear] = e;
        rear = (rear + 1) % MAXSIZE;
    }

    public void delete(){
        if(isEmpty()){
            System.out.println("数据为空");
        }


    }
}
