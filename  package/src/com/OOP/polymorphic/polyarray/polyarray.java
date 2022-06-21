package com.OOP.polymorphic.polyarray;

public class polyarray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];

        persons[0] = new Person("jack", 20);
        persons[1] = new Student("jack0", 20, 100);
        persons[2] = new Student("jack1", 20, 50);
        persons[3] = new Teacher("jack3", 20, 5000);
        persons[4] = new Teacher("jack4", 20, 50000);

        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());//会动态绑定对应的运行类型
            if(persons[i] instanceof Teacher){
                ((Teacher)persons[i]).teach();//两条语句的综合，向下转型
            }else if(persons[i] instanceof Student){
                ((Student)persons[i]).study();//两条语句的综合，向下转型
            }
        }
    }
}
