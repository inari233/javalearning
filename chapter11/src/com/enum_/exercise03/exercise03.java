package com.enum_.exercise03;

public class exercise03 {
    public static void main(String[] args) {
        new Cellphone().testWork(new calculate() {
            @Override
            public void work() {
                System.out.println("完成计算");
            }
        });
    }
}
