package com.LeetCode;

import java.util.ArrayList;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"cir","car"};
        String regStr1 = longestCommonPrefix1(strs);
        System.out.println(regStr1);
    }

    public static String longestCommonPrefix1(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int length = strs[0].length();
        for (String str : strs) {
            if(str.length() < length){
                length = str.length();
            }
        }
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
