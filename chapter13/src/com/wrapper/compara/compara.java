package com.wrapper.compara;

/**
 * 使用原则，结论
 * 1.如果字符存在大量修改操作，建议使用StringBuilder和StringBuffer
 * 2.如果字符存在大量修改操作，并且单线程,使用StringBuilder
 * 3.如果字符存在大量修改操作，并且多线程,使用StringBuffer
 * 4.如果字符串很少修改，被多个对象引用，使用String,比如配置信息等
 *
 * String builder 的使用方法和String buffer 一样
 *
 */

public class compara {
    public static void main(String[] args) {
        //String不可变字符序列，效率低，但是复用率高
        //StringBuffer可变字符序列，效率较高（增删），线程安全
        //StringBuilder可变字符序列，效率最高，现场不安全

        //如果我们对String做大量的修改，建议不要使用String



    }
}
