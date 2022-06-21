package com.LeetCode;

import java.util.HashMap;

/**
 * 外观数列，题目太长长了。自己上leetcode看
 */
public class CountandSay {
    public static void main(String[] args) {
        String s = "11";
        String regStr1 = countAndSay(4);
        System.out.println(regStr1);
    }

    public static String countAndSay(int n) {
        String s = "1";
        if (n == 2) return "11";
        while (n > 2) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                }
                if (s.charAt(i) != s.charAt(i + 1)) {
                    sb.append(count);
                    sb.append(s.charAt(i));
                    count = 1;
                }
                if (i == s.length() - 2) {
                    sb.append(count);
                    sb.append(s.charAt(i + 1));
                    count = 1;
                }
            }
            s = sb.toString();
            n--;
        }
        return s;
    }

//    public static String text(String s) {
//        while ( > 1) {
//            int count = 1;
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < s.length() - 1; i++) {
//                if (s.charAt(i) == s.charAt(i + 1)) {
//                    count++;
//                }
//                if (s.charAt(i) != s.charAt(i + 1)) {
//                    sb.append(count);
//                    sb.append(s.charAt(i));
//                    count = 1;
//                }
//                if(i == s.length() - 2){
//                    sb.append(count);
//                    sb.append(s.charAt(i + 1));
//                    count = 1;
//                }
//            }
//            s = sb.toString();
//            n--;
//        }
//        return s;
//    }
}
