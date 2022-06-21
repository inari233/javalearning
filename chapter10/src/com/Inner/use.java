package com.Inner;

public class use {
    public static void main(String[] args) {
        f(new as(){
            @Override
            public void s() {
                System.out.println("匿名内部类的使用");
            }
        });
    }

    public static void f(as as){
        as.s();
    }
}


interface as{
    public void s();
}