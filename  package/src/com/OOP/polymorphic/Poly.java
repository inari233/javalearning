package com.OOP.polymorphic;

//多态的向上转型
//一个对象的编译类型和运行类型可以不一样
//编译类型在定义对象的时候就决定了，而运行对象可以改变
//等号的左边是编译类型，右边是运行类型
// Animal animal = new Dog();
// animal = new Cat();
//访问属性的时候看的时编译的类型
//多态的向下转型
//子类类型 引用名 = （子类类型）父类引用
//可以使用子类的特有方法
//要求父类的引用要指向当前目标类型的对象
//Animal animal = new Dog();
//因为现在animal这个父类的引用指向Dog
//所以才能向下转型指向Dog
//Dog dog = (dog) animal;
//所有只有向上转型后才能向下转型
//动态绑定机制
//当调用对象方法的时候，该方法会和运行类型绑定
//属性没有动态绑定机制，那里声明就使用那里
public class Poly {
    public static void main(String[] args) {
        Animal animal = new Dog();//编译类型是animal，子类是dog
        System.out.println(animal.a);//看的时编译类型里的a
        animal.cay();//运行时是Dog

        //instanceOf比较操作符，用于判断对象的运行类型是否为XX类型或XX类型的子类型
        System.out.println(animal instanceof Dog);
        System.out.println(animal instanceof Animal);

        animal = new Cat();//运行类型改变了，现在是cat
        //animal.cat();//不能使用子类的特有对象
        //最终运行时还是从运行类型开始找方法,规则和前面一样
        animal.cay();//运行时时cat

        Dog dog = new Dog();
        //animal = dog;//多态的具体体现
        animal.cay();

        Cat cat = (Cat) animal;//多态的向下转型
        cat.cat();
    }
}
