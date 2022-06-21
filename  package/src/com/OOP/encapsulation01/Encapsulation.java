package com.OOP.encapsulation01;

public class Encapsulation {
    public static void main(String[] args) {
        Person person = new Person("jack", 18, 13333);

    }
}

class Person {
    public String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        //构造器里使用set方法就可以对数据进行验证处理
        setAge(age);
        setName(name);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 5) {
            this.name = name;
        } else {
            System.out.println("输入姓名有误");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 1 && age < 120) {
            this.age = age;
        } else {
            System.out.println("年龄输入有误");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
