package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp02 {
    public static void main(String[] args) {
        String content = "a11c_8abc";
        //String regStr1 = "[a-z]";//匹配a-z之间的任意一个字符
        //String regStr1 = "[A-z]";//匹配A-Z之间的任意一个字符
        //String regStr1 = "abc";//默认情况下区分大小写
        //String regStr1 = "(?i)abc";//表示匹配时不区分大小写
        String regStr1 = "[^a-z]";//表示不在a-z之间的任意一个字符
        //String regStr1 = "[abcd]";//表示在abcd中的任意一个字符注意和上面的区别就是加了大括号
        //String regStr1 = "\\D";//匹配非数字符
        //String regStr1 = "\\w";//匹配任意数字，字母，下划线
        //String regStr1 = "\\W";//和上面相反
        //String regStr1 = "\\s";//匹配任意空白字符
        Pattern pattern = Pattern.compile(regStr1);
        //Pattern pattern = Pattern.compile(regStr1, Pattern.CASE_INSENSITIVE);//说明不区分大小写
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
