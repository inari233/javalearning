package com.LeetCode;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * 找出第一个唯一的字符
 */
public class firstUniqChar {
    public static void main(String[] args) {
        String s = "leetcode";
        int i = firstUniqChar1(s);
        System.out.println(i);
    }


    public static int firstUniqChar1(String s) {

        HashMap<Character, Integer> map = new HashMap<>();//key是对应的字符，value是出现的索引
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), -1);
            }
        }
        int firstIndex = s.length();
        boolean flag = false;
        int value;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            value = entry.getValue();
            if(value != -1 && value < firstIndex){
                firstIndex = value;
                flag = true;
            }
        }
        if(!flag){
            firstIndex = -1;
        }
        return firstIndex;

    }
}