package com.OOP.encapsulation01.the_thoryofencapsulation;
//如果子类和父类的变量名一样，那么优先访问子类
//如果子类有并且可以访问那么就直接返回子类的该属性
//子类没有就去其父类查找该属性,如果父类有且可以访问那么就返回父类的该属性
//其父类没有就去访问其父类的父类，然后遵循上述规则，一直到Object类
//子类构造器里有this(),就会屏蔽掉其自带的super()
public class test {
    public static void main(String[] args) {
        son son = new son();
        System.out.println(son.hobby);
        System.out.println(son.getName());

    }
}

class GrandPa{
    String name;
    String hobby = "旅游";
}

class father extends GrandPa{
    String name;
    double salary;
}

class son extends father{
    private String name = "大头儿子";
    int age;

    public String getName() {
        return name;
    }

    public void m1(){
        System.out.println(super.name);
    }
}
