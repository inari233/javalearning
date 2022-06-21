package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexp05 {
    public static void main(String[] args) {
        String content = "13888969893";
        //String regStr1 = "^[\u0391-\uffe5]+$";//验证汉字
        //String regStr1 = "^[1-9]\\d{5}$";//验证1-9开头的六位数字
        String regStr1 = "^1[1|3|8|4]\\d{9}$";
        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()){
            System.out.println(matcher.group(0));
        }

    }
}
