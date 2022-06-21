package com.LeetCode;

public class reverseInt {
    public static void main(String[] args) {
        int x = 1534236469;
        int reverse = reverse(x);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        String s = String.valueOf(x);
        char[] chars;
        if (x >= 0) {
            chars = new char[s.length()];
        } else {
            chars = new char[s.length() - 1];
        }

        for (int i = 0; i < chars.length; i++) {
            chars[i] = s.charAt(s.length() - 1 - i);
        }
        String regStr1 = new String(chars);
        int i = 0;
        i = Integer.parseInt(regStr1);
        if (x < 0) {
            i = -i;
        }
        return i;
    }

}
