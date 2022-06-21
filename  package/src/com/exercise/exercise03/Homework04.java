package com.exercise.exercise03;

public class Homework04 {
    public static void main(String[] args) {
        worker jack = new worker("jack", 1000, 30);
        manager mile = new manager("mile", 5000, 10);

        jack.printWage();
        mile.printWage();

    }
}
