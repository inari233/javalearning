package com.Abstract;

public class Abstract {
    public static void main(String[] args) {

    }
}

/**
 * 将该方法设计为抽象方法
 * 抽象方法就是没有实现的方法
 * 没有实现就是没有方法体
 * 当一个类有抽象方法时，需要将该类声明为abstract类
 * 一般来说抽象类会被继承，由其子类来重写
 *
 */
 abstract class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    //这里的eat方法其实没有什么意义
    //即父类方法不确定性的问题

    public abstract void eat();
}
