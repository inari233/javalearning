package com.LeetCode;

import java.util.HashMap;

public class checkInclusion01 {

    public static void main(String[] args) {
        checkInclusion01 checkInclusion01 = new checkInclusion01();
        boolean b = checkInclusion01.checkInclusion("ab", "eidbaooo");
        System.out.println(b);
    }

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int count = 0;
        while (right < s2.length()){
            char c = s2.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(need.get(c))){
                    count++;
                }
            }
            while (right - left >= s1.length()){
                if(count == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if(need.containsKey(left)){
                    if(need.get(d).equals(window.get(d))){
                        count--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
