package com.OOP.polymorphic.execrise;

public class usualemployee extends Employee{
    public usualemployee(String name, double monthly_salary) {
        super(name, monthly_salary);
    }

    public void work(){
        System.out.println("员工在工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
