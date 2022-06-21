package com.codeblock;

import java.net.PortUnreachableException;
        //只有静态的代码块才会再创建时执行，而非静态的不会
public class detail02 {
    public static void main(String[] args) {
        //1.类加载的情况
        //AA aa = new AA();
        //2.创建子类对象实列时，父类会被加载
        //代码块优先于构造器执行
        AA aa = new AA();
        //3.类的静态成员被调用的时候，类被加载
        //先加载父类再加载子类，先有爹后有儿子
        //System.out.println(cat.n1);
    }
}

class animal {
    static {
        System.out.println("animal的静态代码块被执行");
    }
}

class cat extends animal{
    public static int n1 = 999;
    static {
        System.out.println("CAT的静态代码块被执行");
    }
}

class AA extends BB{

    static {
        System.out.println("AA的静态代码块被执行");
    }
}

class BB{
    static {
        System.out.println("BB的静态代码块被执行");
    }
}
