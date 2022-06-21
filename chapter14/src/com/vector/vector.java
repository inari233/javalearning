package com.vector;

import java.util.Vector;

public class vector {
    public static void main(String[] args) {
        //vector无参则固定先分配10
        //不够就乘2
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        for (int i = 10; i <20; i++) {
             vector.add(i);
        }

        person jack = new person("jack");
        person jack1 = jack;
        jack1.setName(null);
        System.out.println(jack);
    }



}

class person{
    private String name;

    public person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
