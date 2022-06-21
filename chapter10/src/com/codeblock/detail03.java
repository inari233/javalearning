package com.codeblock;

public class detail03 {
    public static void main(String[] args) {
        A a = new A();
    }
}

/**
 * 重点 难点
 */
//创建一个对象时，在一个类中的调用顺序是
//1.先调用静态代码块和静态属性初始化
//静态属性初始化和静态代码块的优先级时一样的
//所以再加载的时候看谁的在前就先调用谁
//2.在调用普通的代码块和普通的属性初始化
//都有也是按照定义的顺序调用
//3.最后才是构造器的调用
class A{
    //静态属性初始化
    private static int n1 = getN1();
    //普通属性初始化
    private int n2 = getN2();
    static {//静态代码块
        System.out.println("A 的静态代码块");
    }
    {
        System.out.println("A 的普通代码块");
    }

    public static int getN1(){
        System.out.println("getN1被调用");
        return 100;
    }

    public int getN2(){
        System.out.println("getN2被调用");
        return 200;
    }

    public A() {//最后调用
        System.out.println("A 的无参构造器被调用");
    }
}
