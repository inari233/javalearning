package com.Abstract.exercise;

public class Manager extends Employee{
    private double bonus = 60000;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理" + getName() + "在工作中");
    }
}
