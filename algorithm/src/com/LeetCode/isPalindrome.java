package com.LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class isPalindrome {
    public static void main(String[] args) {
        String s = new String("A man, a plan, a canal: Panama");
        boolean palindrome1 = isPalindrome1(s);
        System.out.println(palindrome1);

    }

    public static boolean isPalindrome1(String s) {
        ArrayList<String> list = new ArrayList<>();
        String regStr1 = "\\w";
        Pattern pattern = Pattern.compile(regStr1);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            list.add(matcher.group(0));
        }
        for (int i = 0; i < list.size(); i++) {
            if(!list.get(i).toLowerCase().equals(list.get(list.size() - i - 1).toLowerCase())){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s){
        String s1 = s.replaceAll("[^a-zA-Z0\\d]", "").toLowerCase();
        String reverse = new StringBuffer(s1).reverse().toString();
        return reverse.equals(s1);
    }

}
