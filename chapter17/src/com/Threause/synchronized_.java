package com.Threause;

public class synchronized_ {
    public static void main(String[] args) {
        stall stall = new stall();
        Thread thread1 = new Thread(stall);
        Thread thread2 = new Thread(stall);
        Thread thread3 = new Thread(stall);

        thread1.start();
        thread2.start();
        thread3.start();


    }
}

class stall implements Runnable {
    private int num = 100;
    boolean loop = true;
    Object obj = new Object();

    @Override
    public void run() {
        while (loop) {
            m1();
        }
    }

    /**
     * 静态方法的锁要加在类本身上
     */
    public static void m3(){
        synchronized (stall.class){

        }
    }

    private void m1() {

        /**
         * 锁可以加在this自己身上，也可以加在其它对象身上
         */
        synchronized (obj) {
            if (num <= 0) {
                System.out.println("票已经卖完");
                loop = false;
                return;
            }
        }
        System.out.println("售票成功还有" + (--num) + "张票");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        if (num <= 0) {
//            System.out.println("票已经卖完");
//            loop = false;
//            return;
//        }

    }

    private synchronized void m2() {

        if (num <= 0) {
            System.out.println("票已经卖完");
            loop = false;
            return;
        }

        System.out.println("售票成功还有" + (--num) + "张票");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        if (num <= 0) {
//            System.out.println("票已经卖完");
//            loop = false;
//            return;
//        }

    }
}
