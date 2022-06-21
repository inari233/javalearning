package com.wrapper.Integer;

public class WrapperVSString {
    public static void main(String[] args) {
        //包装类（integer）->String
        Integer i = 100;//自动装箱
        //方法1
        String str1 = i + "";
        //方式2
        String str2 = i.toString();
        //方式
        String str4 = String.valueOf(i);

        //String -> 包装类（integer）
        String str5 = "1234";
        Integer i2 = Integer.parseInt(str5);
        Integer integer = new Integer(str5);
    }
}
