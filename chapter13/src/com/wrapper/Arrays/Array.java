package com.wrapper.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class Array {
    public static void main(String[] args) {
        //Arrays的toString方法可以显示数组

        Integer[] integers = {52, 4, 225, 2, 5, 7, 8};

        System.out.println(Arrays.toString(integers));

        //Arrays的sort方法还可以传入两个参数
        //第一个参数是要排序的数组，第二个是实现了Comparator接口的匿名内部类
        //这里体现了接口编程的方式
        Arrays.sort(integers);
        System.out.println(integers);

        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;

                return i2 - i1;

            }
        });
        System.out.println(Arrays.toString(integers));
    }


}
