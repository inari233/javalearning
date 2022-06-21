package com.wrapper.stringbuffer;

public class exercise {
    public static void main(String[] args) {
        String str = null;

        StringBuffer stringBuffer = new StringBuffer();
        //源码会将null转换成null字符串
        stringBuffer.append(str);
        System.out.println(stringBuffer.length());

        //会抛出空指针异常
        StringBuffer stringBuffer1 = new StringBuffer(str);
    }
}
