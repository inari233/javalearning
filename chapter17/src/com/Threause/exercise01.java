package com.Threause;

public class exercise01 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new sdfsf());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hi" + i);
            if(i == 5){
                thread.start();
                thread.join();
            }
        }

    }
}

class sdfsf implements Runnable{
    int n1 = 0;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello" + (n1++));
        }
    }
}
