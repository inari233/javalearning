package com.final_;

public class Final01 {
    public static void main(String[] args) {

    }
}

//如果希望A不被继承
//声明其为final
final class A{}

class c{

    //加了final的方法不能被子类重写
    public final void hi(){

    }
}

//加了final的变量不能更改
class e{
    public static final double TEX_RATE = 0.8;
}

class f{
    public void cry(){
        //局部常量
        final double NUM = 0.01;
    }
}
