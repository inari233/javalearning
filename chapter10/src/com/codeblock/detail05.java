package com.codeblock;

/**
 * 创建一个子类对象时（继承关系）他们的静态属性初始化，静态代码块，普通属性初始化，普通代码块，以及构造器的顺序
 * 1.父类的静态代码块和静态属性初始化（优先级一样，按照定义顺序执行）
 * 2.子类的静态代码块和静态属性初始化（优先级一样，按照定义顺序执行）
 * 3.父类的普通属性初始化和普通代码块（优先级一样，按照定义顺序执行）
 * 4.父类的构造器
 * 5.子类的普通属性初始化和普通代码块（优先级一样，按照定义顺序执行）
 * 6.子类的构造器
 *
 * 就是先加载类再进行初始化
 *
 * 静态方法不能被重写，并且和编译类型一样
 */

public class detail05 {
    public static void main(String[] args) {
        b b = new b();

    }

}

class AAAAA {
    private static int n1 = getN1();
    private int n2 = getN2();

    static{
        System.out.println("父类的静态代码块");
    }

    public AAAAA() {
        //super()
        //普通代码块和普通属性初始化
        System.out.println("父类的构造器");
    }

    public static int getN1(){
        System.out.println("父类的静态属性初始化");
        return 100;
    }

    public static int getN2(){
        System.out.println("父类的普通属性初始化");
        return 500;
    }
}

class b extends AAAAA {
    private static int n1 =getN1();
    private int n2 = getN2();

    public static int getN1(){
        System.out.println("子类的静态属性初始化");
        return 100;
    }

    public b() {
        //super()
        //普通属性初始化和普通代码块
        System.out.println("子类构造器");
    }

    static{
        System.out.println("子类的静态代码块");
    }

    public static int getN2(){
        System.out.println("子类的普通属性初始化");
        return 100;
    }
}
