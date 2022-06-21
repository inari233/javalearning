package com.generic;

public class generic03 {
    public static void main(String[] args) {
        Person<String> stringPerson = new Person<String>("tom");

    }
}

//泛型的作用是：可以在类声明时通过一个标识表示类中的某个属性的类型
//或者时某个方法的返回值的类型,或者时参数类型
class Person<E>{
    //该数据类型是在定义Person对象的时候指定的，即在编译的时候，就确定E时什么类型
    E s;

    public Person(E s) {
        this.s = s;
    }

    private E f(){
        return s;
    }
}
