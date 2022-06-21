package com.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class letterCombinations01 {
    HashMap<Character, Character[]> hashMap;
    List<String> list = new ArrayList<>();




    public static void main(String[] args) {
        letterCombinations01 letter = new letterCombinations01();
        String s = new String("22");
        List<String> strings = letter.letterCombinations(s);
        System.out.println(strings);
    }

    public List<String> letterCombinations1(String digits) {
        HashMap<Character, Character[]> hashMap = new HashMap<>();
        hashMap.put('2', new Character[]{'a', 'b', 'c'});
        hashMap.put('3', new Character[]{'d', 'e', 'f'});
        hashMap.put('4', new Character[]{'g', 'h', 'i'});
        hashMap.put('5', new Character[]{'j', 'k', 'l'});
        hashMap.put('6', new Character[]{'m', 'n', 'o'});
        hashMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        hashMap.put('8', new Character[]{'t', 'u', 'v'});
        hashMap.put('9', new Character[]{'w', 'x', 'y', 'z'});
        List<String> temp = new ArrayList<>();
        int size = digits.length();
        if(size == 0){
            return temp;
        }
        temp.add(digits);
        for (int i = 0; i < size; i++) {
            Character[] chars = hashMap.get(digits.charAt(i));
            List<String> strings = new ArrayList<>();
            char c = digits.charAt(i);
            for (Character aChar : chars) {
                for (String regStr1 : temp) {
                    String replace = regStr1.replace(digits.charAt(i), aChar);
                    strings.add(replace);
                }
            }
            temp = strings;
        }
        return temp;
    }




    public List<String> letterCombinations(String digits) {
        hashMap = new HashMap<>();
        hashMap.put('2', new Character[]{'a', 'b', 'c'});
        hashMap.put('3', new Character[]{'d', 'e', 'f'});
        hashMap.put('4', new Character[]{'g', 'h', 'i'});
        hashMap.put('5', new Character[]{'j', 'k', 'l'});
        hashMap.put('6', new Character[]{'m', 'n', 'o'});
        hashMap.put('7', new Character[]{'p', 'q', 'r', 's'});
        hashMap.put('8', new Character[]{'t', 'u', 'v'});
        hashMap.put('9', new Character[]{'w', 'x', 'y', 'z'});

        char[] chars = digits.toCharArray();
        combinations(chars, 0,new StringBuilder());
        return list;
    }

    public void combinations(char[] chars, int n, StringBuilder sb){
        if(n == chars.length){
            list.add(sb.toString());
            return;
        }
        Character[] characters = hashMap.get(chars[n]);
        for (Character character : characters) {
            sb.append(character);
            combinations(chars, n + 1, sb);
            sb.deleteCharAt(n);
        }
    }

}
