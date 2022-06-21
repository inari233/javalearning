package com.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MaxQueue {
    Deque<Integer> deque;
    Queue<Integer> queue;


    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if(!deque.isEmpty()) {
            return deque.getFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        if(!deque.isEmpty() && deque.getLast() < value){
            deque.pollLast();
        }
        deque.addLast(value);
        queue.add(value);
    }

    public int pop_front() {
        if(!deque.isEmpty() && Objects.equals(deque.getFirst(), queue.peek())){
            deque.pollFirst();
        }
        return queue.poll();
    }
}


