package com.wrapper.stringbuffer;

public class StringtoBuffer {
    public static void main(String[] args) {
        //看string -> stringbuffer
        String s1 = "Hello world";
        //方法一，构造器
        //对s本身没有影响
        StringBuffer stringBuffer = new StringBuffer(s1);
        //方式二：使用append方法
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1.append(s1);


        //stringbuffer -> string
        //方法一，toString
        StringBuffer stringBuffer2 = new StringBuffer("asdf");
        String s4 = stringBuffer2.toString();

        //使用构造器
        String s = new String(stringBuffer2);

    }
}
