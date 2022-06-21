package com.OOP.encapsulation01.execrise;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say(){
        return "my name is " + name + " and my age is " + age;
    }
}
