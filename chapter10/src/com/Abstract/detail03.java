package com.Abstract;

/**
 * 抽象类的本质还是类，所以可以有类的所有成员
 * 一个类继承了抽象类，他就必须实现抽象类的所有抽象方法，除非将自己声明为抽象类
 * 抽象方法不能被static，final，private修饰,因为这些修饰的方法不能被重写，而抽象方法要被重写
 * static和编译类型绑定
 */

public class detail03 {
    public static void main(String[] args) {

    }
}


abstract class s{
    private int age;
    private static String name;

    public abstract void cry();

    public int anInt(){
        return 100;
    }
}

class g extends s{
    @Override
    public void cry() {

    }
}
