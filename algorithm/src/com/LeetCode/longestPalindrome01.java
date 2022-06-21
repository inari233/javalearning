package com.LeetCode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class longestPalindrome01 {
    public static void main(String[] args) {
        longestPalindrome01 rome = new longestPalindrome01();
        String regStr1 = new String("ab");
        String regStr11 = rome.longestPalindrome(regStr1);
        System.out.println(regStr11);
    }

    /**
     * 方法一，中心扩散，从回文字符串的中心向两端进行扩散，和两端向中心扩散正好相反
     * @param s 转入的字符串
     * @return 返回的字串
     */
    public String longestPalindrome1(String s) {
        int max = 0;
        int begin = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int evenMax = isPalindrome_center(chars, i, i + 1);
            int oddMax = isPalindrome_center(chars, i, i);
            int maxPalindrome = Math.max(evenMax, oddMax);
            if(maxPalindrome > max){
                begin = i - (maxPalindrome - 1) / 2;
                end = begin + maxPalindrome - 1;
                max = maxPalindrome;
            }
        }
        return s.substring(begin, end + 1);
    }

    public int isPalindrome_center(char[] chars, int left, int right){
        while(left >= 0 && right < chars.length){
            if(chars[left] == chars[right]){
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     * dp[i][j]表示从i开始，到j结束的字串书否是回文串
     * 回文串的性质，回文串去掉开头和结尾还是回文串
     * 所以状态转移方程就是dp[i][j] = dp[i+1][j-1]
     * @param s 需要判断的字符串
     * @return 最长子回文串
     */
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        int max = 1;
        int begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < j; i++) {
                if(chars[i] == chars[j]){
                    if(j - i < 3){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if(dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    begin = i;
                }
            }

        }
        return s.substring(begin, begin + max);
    }


}
