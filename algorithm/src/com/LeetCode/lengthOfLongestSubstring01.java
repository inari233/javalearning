package com.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class lengthOfLongestSubstring01 {
    public static void main(String[] args) {
        lengthOfLongestSubstring01 length = new lengthOfLongestSubstring01();
        String regStr1 = new String("dvdf");
        int i = length.lengthOfLongestSubstring1(regStr1);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring1(String s) {
        HashSet<Character> ch = new HashSet<>();
        int i = 0;
        int max = 0;
        int count = 0;
        int j = 0;
        while (i < s.length()) {
            if (!ch.contains(s.charAt(i))) {
                ch.add(s.charAt(i));
                count++;
                if (count > max) {
                    max = count;
                }
                i++;
            } else {
                ch.clear();
                count = 0;
                j++;
                i = j;
            }
        }
        return max;
    }

    /**
     * 滑动窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != 0) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < s.length() && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }


    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int rk = -1;
        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                hashSet.remove(chars[i - 1]);
            }
            while (rk + 1 < chars.length && !hashSet.contains(chars[rk + 1])) {
                hashSet.add(chars[rk + 1]);
                rk++;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


}
