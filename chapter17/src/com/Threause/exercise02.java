package com.Threause;

import java.util.Scanner;

/**
 * 用通知的方式来终止其它线程的进行
 * 就是B线程要能修改A线程的循环条件
 */

public class exercise02 {
    public static void main(String[] args) {
        t2 t2 = new t2();
        t1 t1 = new t1();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();

    }
}

class t1 implements Runnable{
    private static boolean loop = true;

    @Override
    public void run() {
        while (loop){
            System.out.println(Math.random()*100);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean isLoop() {
        return loop;
    }

    public static void setLoop(boolean loop) {
        t1.loop = loop;
    }
}

class t2 implements Runnable{
    private Scanner scanner = new Scanner(System.in);
    private char key = ' ';

    @Override
    public void run() {
        while (true) {
            key = scanner.next().charAt(0);
            if(key == 'q'){
                com.Threause.t1.setLoop(false);
                break;
            }
        }

    }
}
