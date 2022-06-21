package com.wrapper.String_;

/**
 * String时final类，不能被其他类继承
 * String有属性 private final char value[];用于存放字符串内容
 * 一定要注意，value时一个final类型，不可被修改，即value不能指向新的
 * 地址，但单个字符的内容可以改变
 */
public class String01 {
    public static void main(String[] args) {


        String name = "jack";
        name = "milk";

        final char value01[] = {'a', 'b', 'c'};
        value01[1] = 'a';

        char v2[] = {'a','f', 'a'};
        //value01 = v2; 报错
    }

}
