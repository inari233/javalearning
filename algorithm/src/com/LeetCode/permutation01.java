package com.LeetCode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

public class permutation01 {
    HashSet<String> set = new LinkedHashSet<>();

    public String[] permutation(String s) {
        boolean[] isVisited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        built(new StringBuilder(), 0, chars);
        System.out.println(set.toString());
        return set.toArray(new String[0]);
    }

    public void built(StringBuilder sb, int i, char[] chars) {
        if (i == chars.length) {
            set.add(sb.toString());
            return;
        }
        for (int j = i; j < chars.length; j++) {
            sb.append(chars[j]);
            built(sb, i + 1, chars);
            sb.deleteCharAt(i);
        }

    }

}
