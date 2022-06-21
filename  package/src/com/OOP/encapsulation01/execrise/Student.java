package com.OOP.encapsulation01.execrise;

class Student extends Person{
    private double score;
    private int id;

    public Student(String name, int age, double score, int id) {
        super(name, age);
        this.score = score;
        this.id = id;
    }

    public String say(){
        return super.say() + "my score is " + score + "and my id is " + id;
    }
}
