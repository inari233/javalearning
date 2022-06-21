package com.LeetCode;

public class Difference {
    int[] diff;

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    public void increment(int i, int j, int val){
        for (int k = i; k <= j; k++) {
            diff[i] += val;
        }
        if(j < diff.length) {
            diff[j] -= val;
        }
    }

    public int[] result(){
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[bookings.length];
        Difference difference = new Difference(res);
        for (int[] booking : bookings) {
            int i = booking[0];
            int j = booking[1];
            int val = booking[2];
            difference.increment(i, j, val);
        }
        return difference.result();
    }
}
