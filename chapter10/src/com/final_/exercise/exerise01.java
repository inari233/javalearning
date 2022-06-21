package com.final_.exercise;

public class exerise01 {
    public static void main(String[] args) {

    }
}

class Circle{
    private double radius;
    private final double PI = 3.14;
    private final double PI2;
    private final double PI3;

    {
        PI3 = 3.1415;
    }

    public Circle(double radius) {
        this.radius = radius;
        PI2 = 3.141;

    }

    public double area(){
        return radius * radius * PI;
    }
}
