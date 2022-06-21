package com.wrapper.stringbuffer;

public class StringBuffer01 {
    public static void main(String[] args) {
        //1.StringBuffer的直接父类是abstractStringBuffer
        //2.StringBuffer实现了串行化
        //3.再父类中有属性char[]value,不是final
        //该value数组存放字符串内容,存放在堆中 ,数组存放在堆中
        //4.因为StringBuffer字符内容是存放在char[]value数组里的
        //所以在变化时不用每次都变更地址(即创建对象)
        StringBuffer sb23 = new StringBuffer("hell0");

        //1.创建一个大小为16的char[]，用于存放字符内容

        StringBuffer sdf = new StringBuffer();

        //2.通过构造器指定char[]大小
        StringBuffer sadf = new StringBuffer(100);
        //30通过给一个String创建一个StringBuffer
    }
}
