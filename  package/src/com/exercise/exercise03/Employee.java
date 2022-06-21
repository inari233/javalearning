package com.exercise.exercise03;

public class Employee {
    private String name = "Rose";
    private double daily_wage;
    private int working_days;

    public Employee(String name, double daily_wage, int working_days) {
        this.name = name;
        this.daily_wage = daily_wage;
        this.working_days = working_days;
    }

    public Employee() {
        System.out.println("父类的无参构造器");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaily_wage() {
        return daily_wage;
    }

    public void setDaily_wage(double daily_wage) {
        this.daily_wage = daily_wage;
    }

    public int getWorking_days() {
        return working_days;
    }

    public void setWorking_days(int working_days) {
        this.working_days = working_days;
    }

    public void printWage(){
        System.out.println("最终工资是" + daily_wage * working_days);
    }
}
