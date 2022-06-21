package com.exercise.exercise03;

public class worker extends Employee{
    private double level = 1.0;

    public worker(String name, double daily_wage, int working_days) {
        super(name, daily_wage, working_days);
    }

    @Override
    public void printWage() {
        System.out.println("普通员工的工资是" + getDaily_wage() * getWorking_days() * level);
    }
}
