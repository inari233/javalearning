package com.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 选择匹配符
 */
public class RegExp {
    public static void main(String[] args) {
        String content = "hanshunpingasdfasdf11111111111 韩 寒冷";
        //String regStr1 = "han|韩|寒冷";//匹配任意空白字符
        //String regStr1 = "\\d{3,4}";//表示匹配匹配3到4个数字组合，尽量匹配多的
        //String regStr1 = "1?";//表示0个或多个
        String regStr1 = "a1?";//表示匹配a或a1
        // String regStr1 = "1*";//表示0个或多个
        //String regStr1 = "1+";//匹配1个或多个1，默认贪婪匹配
        Pattern pattern = Pattern.compile(regStr1);
        //Pattern pattern = Pattern.compile(regStr1, Pattern.CASE_INSENSITIVE);//说明不区分大小写
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }

}
