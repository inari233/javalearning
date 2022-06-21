package com.single;

/**
 * 演示懒汉式的单例模式
 *
 */

public class singleton02 {
    public static void main(String[] args) {

        Cat myCat = Cat.getInstance();


    }
}

//我们希望在程序运行时只能有一个Cat
class Cat{
    private String name;
    private static Cat cat;

    //步骤
    //1.仍然将构造器私有化
    //2.定义一个static静态属性对象
    //3.提供一个public的static方法，可以返回一个cat对象
    //4.懒汉式，只有当用户使用这个方法时才返回这个cat对象，后面调用时，会返回上次创建的cat对象，保证了该对象的单一

    private Cat(String name) {
        this.name = name;
    }

    public static Cat getInstance(){

        if(cat == null){//如果还没有创建对象
            cat =  new Cat("小可爱");
        }
        return cat;
    }
}
