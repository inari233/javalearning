package com.final_;

public class detail03 {
    public static void main(String[] args) {
        System.out.println(BBB.num);

    }
}
/**
 * 单一个类时final的，它的方法就不用加final了
 * final不能修饰构造器
 * final和static搭配使用搭配,效率更高,不会导致类的加载
 * 底层经过了优化
 */

class BBB{
    public final static int num = 1000;

    static {
        System.out.println("BBB静态代码块被执行");
    }
}
