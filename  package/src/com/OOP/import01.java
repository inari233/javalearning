package com.OOP;

//建议需要那个类使用那个类
//import java.util.Scanner;//表示只引入Scanner类
//import java.util.*;//表示引入该包中的所有类

import com.OOP.modifier.A;

import java.util.Arrays;

public class import01 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 78};
        //
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        A a = new A();
        System.out.println(a.n1);

    }
}
