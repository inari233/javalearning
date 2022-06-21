package com.codeblock;

public class Codeblock {
    public static void main(String[] args) {
        movie movie = new movie("asdf");
    }
}

class movie{
    private String name;
    private double price;
    private String directer;


    //我们不论调用哪个构造器创建对象，都会先调用代码块的内容
    //先调用代码块里的内容再调用构造器里的内容
    //普通代码块每创建一次都会执行
    //如果代码块加上static访问修饰符就是静态代码块，只会执行一次,在类加载的时候会执行

    //类什么时候会加载【重要】
    //1.创建对象实列时（new）
    //2.创建子类对象实列时，父类也会被加载
    //3.使用类的静态成员时（静态属性，静态方法）
    {

    }

    public movie(String name, double price, String directer) {
        this.name = name;
        this.price = price;
        this.directer = directer;
    }

    public movie(String name) {
        System.out.println("构造器2被调用");
        this.name = name;
    }

    public movie(String name, double price) {
        this.name = name;
        this.price = price;
    }
}