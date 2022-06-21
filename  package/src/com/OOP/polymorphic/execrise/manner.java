package com.OOP.polymorphic.execrise;

class manner extends Employee{
    private double bonus;

    public manner(String name, double monthly_salary, double bonus) {
        super(name, monthly_salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void manage(){
        System.out.println("经理在管理");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
