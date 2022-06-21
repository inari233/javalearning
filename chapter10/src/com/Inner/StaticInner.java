package com.Inner;

public class StaticInner {
    public static void main(String[] args) {
        //因为是静态的，所以可以直接通过类名访问，前期是满足访问权限
        Outer02.Inner inner = new Outer02.Inner();
        //通过返回实例方法创建
        Outer02.Inner inner1 = Outer02.getInstance();

    }
}

class Outer02{
    private int n1 = 10;
    private static String name;
//  该类是静态内部
    //只能访问外部类的静态成员
    //可以添加任意访问修饰符
    static class Inner{

    }

    public static Inner getInstance() {
        return new Inner();
    }
}
