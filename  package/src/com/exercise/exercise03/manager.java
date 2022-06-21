package com.exercise.exercise03;

public class manager extends Employee{
    private String name = "john";
    private double bonus = 1000;
    private double level = 1.2;

    public manager(String name, double daily_wage, int working_days) {
        super(name, daily_wage, working_days);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    @Override
    public void printWage() {
        System.out.println("经理的工资是" + (getDaily_wage() * getWorking_days() * level + bonus));
    }
}
