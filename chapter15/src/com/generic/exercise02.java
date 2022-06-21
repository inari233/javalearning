package com.generic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class exercise02 {

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 132456, new MyDate(12, 25, 2071)));
        employees.add(new Employee("jack", 456656, new MyDate(12, 25, 2211)));
        employees.add(new Employee("jack", 1122456, new MyDate(12, 25, 1231)));
        employees.add(new Employee("jack", 5462456, new MyDate(12, 25, 2011)));

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (o1.getName() == o2.getName()) {
                    return (o1.getBirthday()).compareTo(o2.getBirthday());
                }
                return (o1.getName()).compareTo(o2.getName());
            }
        });

        System.out.println(employees);


    }
}

class Employee {
    private String name;
    private double salary;
    private MyDate birthday;

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
    }


}

class MyDate implements Comparable<MyDate> {
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public String toString() {
        return "MyDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(MyDate myDate1) {
        return (year * 365 + month * 30 + day) - (myDate1.year * 365 + myDate1.month * 30 + myDate1.day);
    }
}



