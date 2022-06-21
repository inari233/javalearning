package com.Abstract.exercise;

public class test {
    public static void main(String[] args) {
        Employee e = new CommonEmployee("jack", 50, 8000);
        Employee e1 = new Manager("jack", 50, 8000, 50000);
        e.work();
        e1.work();

    }
}
