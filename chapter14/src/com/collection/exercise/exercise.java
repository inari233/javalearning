package com.collection.exercise;

import java.util.ArrayList;
import java.util.Iterator;

public class exercise {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new Dog("jack", 51));
        list.add(new Dog("jak", 512));
        list.add(new Dog("jck", 511));
        list.add(new Dog("jac", 513));

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        for (Object o : list) {
            System.out.println(o);
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
