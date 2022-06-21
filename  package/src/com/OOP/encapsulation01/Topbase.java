package com.OOP.encapsulation01;

//子类的构造器会自动调用父类的构造器，二父类的构造器还会接着调用其父类的构造器，一直上溯到Object类
//默认调用的是父类的无参构造器，如果想要调用其它构造器，需要指定
public class Topbase {
    public Topbase() {
        System.out.println("Topbase()构造器被调用");
    }
}
