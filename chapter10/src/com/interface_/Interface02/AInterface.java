package com.interface_.Interface02;

public interface AInterface {
    //接口可以写属性
    public int n1 = 13;
    //写方法
    //在接口中，抽象方法可以省略abstract关键字
    public void hi();
    //在jdk8后，可以有默认实现方式，需要使用default关键字
    default public void ok(){
        System.out.println("ok");
    }

    //在jdk8后还可以有静态方法
        public static void bye(){
        System.out.println("bye");
    }
}
