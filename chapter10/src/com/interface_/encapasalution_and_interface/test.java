package com.interface_.encapasalution_and_interface;

public class test {
    public static void main(String[] args) {
        SmallMonkey monkey = new SmallMonkey("悟空");
        monkey.climb();
        monkey.swim();
    }
}


class Monkey{
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void climb(){
        System.out.println(name + "在爬树");
    }
}

interface swimming{

    public void swim();
}

//当子类继承了父类就自动拥有了父类的能力
//如果子类想要拓展，就可以通过实现接口的方法来进行
class SmallMonkey extends Monkey implements swimming{
    public SmallMonkey(String name) {
        super(name);
    }


    @Override
    public void swim() {
        System.out.println("通过学习，学会了游泳");
    }
}
