package com.generic;

import java.util.*;

public class exercise01 {
    public static void main(String[] args) {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student("tom"));
        set.add(new Student("to2"));
        set.add(new Student("to3"));

        for (Student student : set) {
            System.out.println(student.getName());
        }

        HashMap<String,Student> map = new HashMap<>();
        map.put("tom", new Student("tom"));
        map.put("to2", new Student("to2"));
        map.put("to3", new Student("to3"));
        map.put("to4", new Student("to5"));
        map.put("to5", new Student("to5"));

        for (String s : map.keySet()) {
            System.out.println(s + "=" + map.get(s));
        }

        Set<Map.Entry<String, Student>> entries = map.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();

        }


    }
}

class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
