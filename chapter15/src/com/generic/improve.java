package com.generic;

import java.util.ArrayList;

public class improve {
    public static void main(String[] args) {
        //表示存放在集合里的是Dog
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("w", 5));
        arrayList.add(new Dog("i", 5));
        arrayList.add(new Dog("k", 5));
        arrayList.add(new Dog("k", 5));

        for (Dog dog : arrayList) {
            System.out.println(dog.getName() + dog.getAge());
        }

    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
