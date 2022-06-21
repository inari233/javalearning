package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 */
public class Zconvert {

    public static void main(String[] args) {
        Zconvert zconvert = new Zconvert();
        String s = new String("AB");
        String convert = zconvert.convert(s, 1);
        System.out.println(convert);
    }

    /**
     * 也可以直接用stringbuilder数组直接解决
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        char[] chars = s.toCharArray();
        int row = 0;
        boolean up = true;
        List<List<Character>> lists = new ArrayList<>();
        for (char aChar : chars) {
            if (lists.size() < numRows) {
                ArrayList<Character> list = new ArrayList<>();
                lists.add(list);
            }
            if (up && row < numRows) {
                lists.get(row).add(aChar);
                row++;
            }
            if (row == numRows) {
                row -= 2;
                up = false;
                continue;
            }
            if (!up && row >= 0) {
                lists.get(row).add(aChar);
                row--;
            }
            if (row < 0) {
                row += 2;
                up = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (List<Character> list : lists) {
            for (Character character : list) {
                sb.append(character);
            }
        }

        return sb.toString();
    }
}
