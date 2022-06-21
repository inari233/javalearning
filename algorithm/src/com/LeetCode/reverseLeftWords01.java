package com.LeetCode;

import java.util.Arrays;

public class reverseLeftWords01 {
    public static void main(String[] args) {
        reverseLeftWords01 words01 = new reverseLeftWords01();
        String s = "lrloseumgh";
        String regStr1 = words01.reverseLeftWords(s, 6);
        System.out.println(regStr1);
    }

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, chars.length - n - 1);
        reverse(chars, chars.length - n, chars.length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right){
        while (left <= right){
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
    }
}
