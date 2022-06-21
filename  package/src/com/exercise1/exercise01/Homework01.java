package com.exercise1.exercise01;

public class Homework01 {
    public static void main(String[] args) {
        Person[] p = new Person[3];
        Person t = new Person();
        p[0] = new Person("milk", 33, "employee");
        p[1] = new Person("jack", 39, "boss");
        p[2] = new Person("lily", 40, "work");

        for (int i = 0; i < p.length - 1; i++) {
            for (int j = 0; j < p.length - 1 - i; j++) {
                if (p[j].getAge() < p[j + 1].getAge()) {
                    t = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = t;
                }
            }

        }
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].getAge());
        }
    }
}
