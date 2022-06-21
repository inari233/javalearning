package com.wrapper.Arrays;

import java.util.Arrays;

public class binarysearcg {
    public static void main(String[] args) {
        Integer[] integer = {1, 2, 5, 45, 86,566};
        //二叉查找必须数组要是有序的才行
        int index = Arrays.binarySearch(integer,5);
        System.out.println(index);

        //copyof数组的复制
        Integer[] newayy = Arrays.copyOf(integer,4);
        System.out.println(Arrays.toString(newayy));
    }

}
