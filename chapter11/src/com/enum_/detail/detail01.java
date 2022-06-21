package com.enum_.detail;

public class detail01 {
    public static void main(String[] args) {

    }
}
//enum隐式的继承了Enum,所以不能再继承其它类了
//enum ss extends detail01{
//
//}
//但是可以实现接口

interface IPlaying{
    public void playing();
}
enum music implements IPlaying{
    ;


    @Override
    public void playing() {

    }
}
