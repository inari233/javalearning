package com.OOP.polymorphic.execrise;

public class Employee {
    private String name;
    private double monthly_salary;

    public Employee(String name, double monthly_salary) {
        this.name = name;
        this.monthly_salary = monthly_salary;
    }

    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee) obj;
        if (e.getName() == this.name) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMonthly_salary() {
        return monthly_salary;
    }

    public void setMonthly_salary(double monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public double getAnnual() {
        return monthly_salary * 12;
    }
}
