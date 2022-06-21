package com.StaticMethor;

//当方法中不涉及任何和对象相关的成员，则可以将方法设计出静态方法，提高开发效率
public class stu {

    private static double fee = 0;

    public void payFee(double fee){
        stu.fee += fee;
    }
}
