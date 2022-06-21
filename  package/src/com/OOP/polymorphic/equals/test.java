package com.OOP.polymorphic.equals;

public class test {
    public static void main(String[] args) {
        Person jack = new Person("jack", 15, 1234);
        Person jack1 = new Person("jack", 15, 1234);
        System.out.println(jack.equals(jack1));
        System.out.println(jack.toString() + "\t" + jack.hashCode());


    }
}

class Person {
    private String name;
    private int age;
    private double id;

    public Person(String name, int age, double id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    //toString方法
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return p.age == age && p.id == id && p.name.equals(name);
        }
        return false;
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

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
}

