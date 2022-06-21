package com.Threause;

public class Thread02 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.start();

        for (int i = 0; i < 80; i++) {
            System.out.println("main线程" + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class T1 extends Thread{
    int n1 = 0;
    @Override
    public void run() {
        while (true){
            System.out.println("小猫叫");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(++n1 > 50){
                break;
            }
        }
    }
}
