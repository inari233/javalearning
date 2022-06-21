package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexp09 {
    public static void main(String[] args) {
        String content = "-21.123";
        String regStr1 = "^[+-]?(([1-9]\\d*)|0)\\.?\\d+$";
        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
