package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexp04 {
    public static void main(String[] args) {
        String content = "1-j";
        //String regStr1 = "^[0-9]+\\-[a-z]+$";//表示的时原文本必须以一个数字或多个开头
        String regStr1 = "han\\b";//表示以han结尾，空格默认时另一个
        Pattern compile = Pattern.compile(regStr1);
        Matcher matcher = compile.matcher(content);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }

    }
}
