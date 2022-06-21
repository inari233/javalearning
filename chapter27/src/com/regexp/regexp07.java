package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexp07 {
    public static void main(String[] args) {
        String content = "12321-333444555";
        String regStr1 = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
