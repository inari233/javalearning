package com.LeetCode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class strStr {

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int i = strStr1(haystack, needle);
        System.out.println(i);
    }

    public static int strStr1(String haystack, String needle) {
        int[] next = new int[needle.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
                next[i] = j;
            }
        }
        int j = 0;
        for (int k = 0; k < haystack.length(); k++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(k)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(k)) {
                j++;
            }

            if (j == needle.length()) {
                return k - j + 1;
            }
        }
        return -1;
    }


    public static int strStr2(String haystack, String needle) {
        int n_size = needle.length();
        int[] next = new int[n_size];
        next[0] = 0;
        int i = 0, j = 0;
        while (i < n_size) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                 j = next[j - 1];
            }
            if(needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            next[i++] = j;
        }
        j = 0;
        i = 0;
        while (i < haystack.length()){
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return  i - j + 1;
            }
            i++;
        }
        return -1;

    }


}
