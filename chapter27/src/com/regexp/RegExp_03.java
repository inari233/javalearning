package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp_03 {
    public static void main(String[] args) {
        String content = "abc$(a.bc(.123(";
        //如果要匹配.就要用转义字符
        //单个.表示匹配所有字符
        String regStr = ".";
        String regStr1 = "\\d{3}";
        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
