package com.single;

public class singleton01 {
    public static void main(String[] args) {

        //可以直接获取对象
        GirlFriend my_girlfriend = GirlFriend.getInstance();

    }
}

//有一个类，girlfriend
//只能有一个女朋友

class GirlFriend{
    private String name;

    //单例模式饿汉式
    //如何保证只能创建一个
    //1.将构造器私有化
    //2.在类的内部初始化一个
    //3为了使用该对象，使用一个public static的方法返回一个实列

    //为了静态的返回方法可以使用，所以也设置为静态的
    //饿汉式可能创建了对象没有使用
    private static GirlFriend gf = new GirlFriend("小红红");

    private GirlFriend(String name) {
        this.name = name;
    }

    public static GirlFriend getInstance(){
        return gf;
    }
}

