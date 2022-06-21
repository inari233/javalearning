package com.exeception.exeception_;

public class exception01 {
    public static void main(String[] args) {
        int num1 = 100;
        int num2 = 0;
        try {
            int res = num1 / num2;
        }catch (Exception e){
            System.out.println("出现异常的原因是" + e.getMessage());
        }

        System.out.println("程序继续进行");
    }

}
