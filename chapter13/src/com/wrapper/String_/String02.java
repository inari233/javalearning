package com.wrapper.String_;

/**
 * String有两种创建方式
 * 1.String s = "asdf";
 * 2.String s2 = new String ("asdf");
 *
 * 方式一：先从常量池查看是否有"asdf"数据空间，如果有，直接指向
 * 如果没有则重新创建，然后指向，s最终指向的时常量池的空间地址
 * 方式二：现在堆中创建空间，里面维护了value属性，指向常量池的asdf空间
 * 如何常量池没有asdf，重新创建，如果有，直接通过value指向。最终指向的是
 * 堆中的空间地址
 */

public class String02 {
    public static void main(String[] args) {
        String s = "asdf";//指向常量池里asdf的地址
        String s2 = new String("asdf");//指向堆中的一个string对象，该对象的value指向常量池里的asdf

//      inter，如果常量池里有该字符串，则返回该字符串的地址，如果没有就在常量池里先
        //创建一个，再返回它的地址
        System.out.println(s == s.intern());
    }
}
