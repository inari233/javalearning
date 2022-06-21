package com.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String01 {
    public static void main(String[] args) {
        int i = 1;
        String content = "I am your father";
        String regStr1 = "[a-zA-Z]+";

        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println((i++) + matcher.group(0));
        }
    }
}
