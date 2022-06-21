package com.Abstract;

/**
 * 抽象类不能被实列化
 */
public class Abstractdetail01 {
    public static void main(String[] args) {
        //a a = new a();
    }
}
//抽象类可以没有抽象方法，但是有抽象方法的类必须声明为抽象类
//抽象类可以有实现的方法
abstract class a{
    public void hi(){
        System.out.println("hi");
    }

}
