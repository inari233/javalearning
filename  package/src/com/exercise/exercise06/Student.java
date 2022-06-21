package com.exercise.exercise06;

public class Student extends Person {
    private int stu_id;

    public Student(String name, int age, String sex, int stu_id) {
        super(name, age, sex);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    @Override
    public String play() {
        return getName() + "爱玩足球";
    }

    public void study(){
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                '}';
    }
}
