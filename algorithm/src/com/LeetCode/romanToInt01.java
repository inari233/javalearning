package com.LeetCode;

import java.util.HashMap;
import java.util.Stack;

public class romanToInt01 {
    public static void main(String[] args) {
        String s = new String("MCMXCIV");
        romanToInt01 romanToInt01 = new romanToInt01();
        int i = romanToInt01.romanToInt(s);
        System.out.println(i);
    }

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if(stack.size() != 0 && map.get(s.charAt(i)) > map.get(stack.peek())){
                ans = ans + map.get(s.charAt(i)) - 2 * map.get(stack.peek());
                continue;
            }
            ans += map.get(s.charAt(i));
            stack.push(s.charAt(i));
        }
        return ans;
    }
}
