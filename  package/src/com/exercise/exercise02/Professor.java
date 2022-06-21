package com.exercise.exercise02;

class Professor extends Teacher{
    private double salary_level = 1.3;

    public Professor(String name, int age, String post, double salary, double salary_level) {
        super(name, age, post, salary);
        this.salary_level = salary_level;
    }

    @Override
    public void introduce() {
        System.out.println(super.toString() + "salary = 1.3");
    }


}
