package com.exeception.customeexceprtion;

public class custome {
    public static void main(String[] args) {
        int age = 150;
        if(!(age > 18 && age < 120)){
            throw new cc("年龄需要在18到120之间");
        }
        System.out.println("你的年龄范围正常");

    }
}

class cc extends RuntimeException{
    public cc(String message) {
        super(message);
    }
}
