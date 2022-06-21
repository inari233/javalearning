package com.codeblock;

public class detail04 {
    public static void main(String[] args) {
        BBB bbb = new BBB();

    }
}

class AAA{

    {
        System.out.println("AAA的普通代码块");
    }
    public AAA() {
        System.out.println("AAA()构造器被调用");
    }
}

class BBB extends AAA{
    {
        System.out.println("BBB的普通代码块被调用");
    }

    public BBB() {
        //隐藏了两句话
        //super()
        //调用本类的普通代码块和普通属性初始化
        System.out.println("BBB()构造器被调用");
    }
}
