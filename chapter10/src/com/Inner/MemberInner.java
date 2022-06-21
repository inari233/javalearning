package com.Inner;

public class MemberInner {
    public static void main(String[] args) {
        Outer outer = new Outer();

        //外部其他类访问成员内部类的三种方法
        //1.被成员内部类当成已成成员来使用
        Outer.Inner inner1 = outer.new Inner();


        //在类的内部定义一个返回实列的方法
        Outer.Inner inner = outer.gerInstance();
        inner.hi();
    }
}

class Outer {
    private int n1 = 10;

    /**
     * 成员内部类定义在内部类的成员位置
     * 可以加任意地访问修饰符因为当作成员使用
     */
    class Inner {
        public void hi(){
            System.out.println("hi");
        }
    }

    public void hi(){
        new Inner().hi();
    }

    public Inner gerInstance(){
        return new Inner();
    }
}
