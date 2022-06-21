package com.LeetCode;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
 */
public class isAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        isAnagram1(s, t);
    }

    public static boolean isAnagram1(String s, String t) {
        char[] c1 = new char[s.length()];
        char[] c2 = new char[t.length()];
        s.getChars(0, s.length(), c1, 0);
        t.getChars(0, t.length(), c2, 0);
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
