package com.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class generateParenthesis01 {
    char[] chars = {'(', ')'};
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        generateParenthesis01 g = new generateParenthesis01();
        List<String> strings = g.generateParenthesis(3);
        System.out.println(strings);
    }

    public List<String> generateParenthesis1(int n) {
        generate(0, new StringBuilder(), n * 2);
        return list;
    }

    public void generate(int n, StringBuilder sb, int num){
        if(n == num){
            if(isValid(sb.toString())){
                list.add(sb.toString());
            }
            return;
        }

        for (char aChar : chars) {
            sb.append(aChar);
            generate(n + 1, sb, num);
            sb.deleteCharAt(n);
        }
    }

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars1 = s.toCharArray();
        for (char c : chars1) {
            if(c == '(')stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public List<String> generateParenthesis(int n){
        dfs("", n, n);
        return list;
    }


    public void dfs(String s, int left, int right){
        if(left == 0 && right == 0){
            list.add(s);
            return;
        }
        if(right < left){
            return;
        }
        if(left > 0){
            dfs(s + '(',left - 1, right);
        }
        if(right > 0){
            dfs(s + ')', left, right - 1);
        }
    }
}
