package com.Inner;

/**
 * 局部内部类定义在外部类的局部变量里（一般是方法）
 * 局部内部类可以访问外部类的所有成员，以及私有的
 * 作用域只在包含这个类的方法里
 * 不能添加访问修饰符，可以加final，即不能被继承
 * 不能从外部其他类中访问（以为是局部类）
 * 如果局部类和外部类重名时，遵守就近原则，想要访问外部类可以用外部类名.this
 */
public class LocalInner {
    private int n1 = 10;

    public void v1(){

        class inner{

        }
    }

    class inner02{

    }
}
