package com.LeetCode;

/**
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数 myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 */
public class myAtoi {
    public static void main(String[] args) {
        String s = " ";
        int i = myAtoi3(s);
        System.out.println(i);
    }

    public static int myAtoi1(String s) {
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
            if (s.charAt(i) == '-') {
                flag = true;
            }
        }
        String s2 = new String(sb);
        int i;
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        String min = new String(String.valueOf(minValue));
        String max = new String(String.valueOf(maxValue));
        if (s2.compareTo(max) < 0) {
            i = maxValue;
        } else if (s2.compareTo(min) < 0) {
            i = minValue;
        } else {
            i = Integer.parseInt(s2);
        }
        if (flag) {
            i = -i;
        }
        return i;
    }


    public static int myAtoi2(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int t = 0;
        int k = 0;
        while (t < s.length()) {
            if (s.charAt(t) == ' ') {
                t++;
            } else if (s.charAt(t) >= '0' && s.charAt(t) <= '9') {
                sb.append(s.charAt(t));
                t++;
            } else if (s.charAt(t) == '-') {
                k++;
                t++;
                flag = true;
            } else if (s.charAt(t) == '+') {
                t++;
                k++;
            } else {
                break;
            }
        }
        String s2 = new String(sb);
        int i = 0;
        boolean flag1 = false;
        if (s2.equals("") || k == 2 || s2.charAt(0) == '0') {
            return i;
        }
        try {
            i = Integer.parseInt(s2);
        } catch (NumberFormatException e) {
            i = Integer.MAX_VALUE;
            flag1 = true;
        }
        if (flag && flag1) {
            i = -i - 1;
        } else if (flag) {
            i = -i;
        }
        return i;
    }


    public static int myAtoi3(String s) {
        boolean flag = false;
        int i = 0;
        int r = 0;
        int res = 0;
        if(s.equals("")){
            return 0;
        }
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-') {
            flag = true;
        }
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            i++;
        }
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
            r = s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && r > 7)) {
                return !flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + r;
            i++;
        }
        return flag ? -res : res;
    }

    public static boolean isdigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }




}
