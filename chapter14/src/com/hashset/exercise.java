package com.hashset;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class exercise {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add(new Employee("jack", 56));
        set.add(new Employee("jack", 55));
        set.add(new Employee("jack", 53));
        set.add(new Employee("jack", 52));

        System.out.println(set);
        int n1 = 1;
        int n2 = 2;
        int n3 = (n1 = n2);
        System.out.println(n3);
    }





}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getAge() == employee.getAge() && Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
