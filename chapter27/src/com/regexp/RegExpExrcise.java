package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpExrcise {
    public static void main(String[] args) {
        String content = "9l1267631@qq.com";
        String regStr1 = "^\\w+@([a-zA-Z]+\\.)+[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
