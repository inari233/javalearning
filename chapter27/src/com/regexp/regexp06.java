package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexp06 {
    public static void main(String[] args) {
        //String content = "5225";
        String content = "asdasdasd11asdasd22asdasd66";
        //String regStr1 = "(\\d)(\\d)\\2\\1";
        String regStr1 = "(\\d)\\1";//找到两个连续相同的数字

        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
