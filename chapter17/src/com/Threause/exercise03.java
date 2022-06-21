package com.Threause;

public class exercise03 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Thread thread1 = new Thread(bankAccount);
        Thread thread2 = new Thread(bankAccount);
        thread1.start();
        thread2.start();
    }
}

class BankAccount implements Runnable{
    private int deposit = 100000;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            withdraw();
        }
    }

    public void withdraw(){
        synchronized (this) {
            if(deposit <= 0){
                System.out.println("账务没钱了");
                loop = false;
                return;
            }
            System.out.println( "已取款1000"+"账户剩余余额为" + (deposit -= 1000));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
