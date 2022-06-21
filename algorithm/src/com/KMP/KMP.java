package com.KMP;

public class KMP {
    public static void main(String[] args) {
        String s = "AAABA";
        int[] next = KMPNext(s);
        for (int i : next) {
            System.out.print(i);
        }
        String s2 = "AB";
        int i = KMPSearch(s, s2, next);
        System.out.println(i);
    }


    public static int[] KMPNext(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }

            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }


    public static int KMPSearch(String str1, String str2, int[] next) {
        for (int j = 0, i = 0;i < str1.length();++i){
            while (j > 0 && str1.charAt(i) != str2.charAt(j)){
                j = next[j - 1];
            }

            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            if (j == str2.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
