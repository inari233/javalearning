package com.wrapper.Integer;

public class Integer01 {
    public static void main(String[] args) {
        //手动装箱 int -> integer
        int n1 = 10;

        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱
        //integer -> int


        //jdk5以后就可以自动装箱和拆箱了
        //自动装箱
        int n3 = 200;
        //int -> integer
        Integer integer2 = n3;
        //自动拆箱
        //integer -> int
        int n4 = integer2;

        //其它包装类也一样
        //只要有基本数据类型，判断的就是值是否相同
    }
}
