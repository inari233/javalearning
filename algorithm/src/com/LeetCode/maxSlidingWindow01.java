package com.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class maxSlidingWindow01 {
    public static void main(String[] args) {

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue queue = new MonotonicQueue();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.push(nums[i]);

            } else {
                queue.push(nums[i]);
                list.add(queue.max());
                queue.pop(nums[i - k + 1]);
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            res[index++] = integer;
        }
        return res;
    }
}

class MonotonicQueue {
    LinkedList<Integer> linkedList = new LinkedList<>();

    public void push(int val) {
        while (!linkedList.isEmpty() && val > linkedList.getLast()) {
            linkedList.pollLast();
        }
        linkedList.addLast(val);
    }

    public int max() {
        return linkedList.getFirst();
    }

    public void pop(int val) {
        if (val == linkedList.getFirst()) {
            linkedList.pollFirst();
        }
    }
}
