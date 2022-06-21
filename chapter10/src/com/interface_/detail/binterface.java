package com.interface_.detail;

public interface binterface {
    //用接口名.属性访问

    int n1 = 1;//等价于public static final int n1 = 1;必须要初始化

    public void hi();

    public void bye();
}

//接口不能继承类但是可以继承接口，接口只能是public的

interface cinterface extends binterface{

}
