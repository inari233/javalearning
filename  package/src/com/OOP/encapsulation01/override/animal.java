package com.OOP.encapsulation01.override;

public class animal {
    public AAA cal(){
        return null;
    }

}
//方法重写中，子类的方法返回类型要和父类一样，或者是父类的子类
//子类的重写方法不能缩小父类方法的访问权限
//方法重载对返回的类型没有要求,且对修饰符也没有要求
class Dog extends animal{
    public BBB cal(){
        return null;
    }
}