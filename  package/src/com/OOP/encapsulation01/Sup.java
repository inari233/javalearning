package com.OOP.encapsulation01;

public class Sup extends Topbase {
    public String name;
    public int age;
    private double salary;

    public Sup(String name) {
        this.name = name;
        System.out.println("父类的(String name)构造器被调用");
    }
}
