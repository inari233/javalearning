package com.LeetCode;

import java.util.HashMap;

public class minWindow01 {


    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int right = 0, left = 0;
        int start = 0, len = Integer.MAX_VALUE;
        int count = 0;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(need.get(c).equals(window.get(c))){
                    count++;
                }
            }
            while (count == need.size()){
                if(right - left < len){
                    len = right - left;
                    start = left;
                }
                char r = s.charAt(left);
                left++;
                if(need.containsKey(r)){
                    if(need.get(r).equals(window.get(r))){
                        count--;
                    }
                    window.put(r, window.get(r) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
