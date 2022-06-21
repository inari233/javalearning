package com.LeetCode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {




    }

    /**
     * 判断字符串中的括号是否有效
     * 比如：（），是有效的，{】是无效的
     * @param s
     * @return
     */

    public static boolean isValid(String s) {
        char[] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);
        Stack<Character> stack = new Stack<>();
        for (Character character : chars) {
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else if (character == ')' || character == ']' || character == '}') {
                if (character == ')') {
                    if (stack.size() != 0 && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (character == ']') {
                    if (stack.size() != 0 && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    if (stack.size() != 0 && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0;
    }


    public boolean BetterIsValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}


