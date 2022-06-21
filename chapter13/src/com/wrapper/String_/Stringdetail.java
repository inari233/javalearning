package com.wrapper.String_;

public class Stringdetail {
    public static void main(String[] args) {
        //底层会进行优化，等价于a = "abcasdf";
        //所以只创建了一个对象
        String a = "abc" + "asdf";
        //底层会在常量池里创建两个常量
        //并不是把原来地址上的hello改成asd
        String a1 = "hello";
        a1 = "asd";

        String s1 = "hello";
        String s2 = "world";


        //先创建一个StringBuilder sb = new StringBuilder()
        //执行sb.append(hello),再执行sb.append(world)
        //最后s3 = sb.toString
        //最后s3指向堆中的对象（string）value
        String s3 = s1 + s2;
    }
}
