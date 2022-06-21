package com.debug;

import java.util.Arrays;

public class Debug {
    public static void main(String[] args) {
        int[] arr = {1, -1, 10, 35, 6, 84,2};
        //我们想看sort方法的源码是怎么执行的
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
        System.out.println("");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("6");
        System.out.println("4");
        System.out.println("1");
        System.out.println("4");
        System.out.println("");
    }
}
