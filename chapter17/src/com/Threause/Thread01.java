package com.Threause;

public class Thread01 {
    public static void main(String[] args) {
        //创建一个cat对象可以当成线程使用
        Cat cat = new Cat();
        //启动一个线程
        cat.start();
        //当main线程启动一个子线程Thread-0时，主线程不会阻塞，会继续执行
        //这是子线程和主线程会交替执行
        System.out.println("主线程会继续执行" + Thread.currentThread().getName());//
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * 当一个类继承了Thread；饿哦，该类就可以当成线程使用
 */
class Cat extends Thread{

    int times = 0;
    @Override
    public void run() {//重写run方法，写上自己的业务逻辑
        while (true) {
            System.out.println("喵喵" + (++times));
            //让该线程休眠1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(times == 80){
                break;
            }
        }
    }
}
