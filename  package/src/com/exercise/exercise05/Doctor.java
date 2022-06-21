package com.exercise.exercise05;

import java.util.Objects;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        Doctor doctor = (Doctor) o;
        return age == doctor.age && gender == doctor.gender && Double.compare(doctor.sal, sal) == 0 && name.equals(doctor.name) && job.equals(doctor.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, gender, sal);
    }
}
