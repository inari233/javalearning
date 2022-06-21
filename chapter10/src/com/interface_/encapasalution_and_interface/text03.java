package com.interface_.encapasalution_and_interface;

/**
 * 接口类型可以指向显现了该接口的类的实列
 * 接口类型也可以向下转型
 * 和继承一样
 */

public class text03 {
    public static void main(String[] args) {
        USB[] u = new USB[3];
        u[0] = new PC();
        u[1] = new P();
        u[2] = new PC();

        text text = new text();
        text.t(u);

    }
}

interface USB{
    public void stair();
    public void stop();
}

class PC implements USB{

    @Override
    public void stair() {
        System.out.println("电脑开始");
    }

    @Override
    public void stop() {
        System.out.println("电脑结束");
    }

    public void programmer(){
        System.out.println("编程");
    }
}

class P implements USB{

    @Override
    public void stair() {
        System.out.println("手机开始");
    }

    @Override
    public void stop() {
        System.out.println("手机结束");
    }

    public void call(){
        System.out.println("打电话");
    }
}


class text{
    public void t(USB[] u){
        for (int i = 0; i < u.length; i++) {
            u[i].stair();
            u[i].stop();
            if(u[i] instanceof PC){
                ((PC)u[i]).programmer();
            }
            if(u[i] instanceof P){
                ((P)u[i]).call();
            }
        }
    }
}