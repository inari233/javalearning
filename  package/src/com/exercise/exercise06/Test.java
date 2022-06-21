package com.exercise.exercise06;

public class Test {
    public static void main(String[] args) {

        Person[] person = new Person[4];

        TestPerson testPerson = new TestPerson();
        person[0] = new Teacher("jack",59, "man",400 );
        person[1] = new Teacher("milk",20, "woman",300 );
        person[2] = new Student("john",14, "woman",123 );
        person[3] = new Student("milk",15, "man",324 );

        testPerson.bubble(person);

        for (int i = 0; i < person.length; i++) {
            System.out.println(person[i]);
            testPerson.supervise(person[i]);
        }

    }
}

class TestPerson{
    public void supervise(Person p){
        if(p instanceof Teacher){
            ((Teacher)p).teach();
        }else if(p instanceof Student){
            ((Student)p).study();
        }
    }

    public void bubble(Person person[]){
        Person t = new Person();
        for (int i = 0; i < person.length - 1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if(person[j].getAge() < person[j + 1].getAge()){
                    t = person[j];
                    person[j] = person[j + 1];
                    person[j + 1] = t;
                }
            }
        }
    }
}
