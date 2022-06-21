package com.file;

import java.io.Serializable;
import java.util.Properties;

public class exercise03 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("name", "tom");
        properties.setProperty("age", "5");
        properties.setProperty("color", "red");

    }
}

class Dog01 implements Serializable{
    private String name;
    private int age;
    private String color;
}
