package com.Threause;

import java.util.Date;

public class Thread03 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
    }
}


class Dog implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("开叫");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
