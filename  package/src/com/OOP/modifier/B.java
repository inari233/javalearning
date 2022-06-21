package com.OOP.modifier;

public class B {
    public void say(){
        A a = new A();
        //同一个包可以访问除private之外的所有
        System.out.println(a.n1 + a.n2 + a.n3);
    }

}
