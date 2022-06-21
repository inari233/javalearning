package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class countPrimes01 {
    public static void main(String[] args) {
        countPrimes01 countPrimes01 = new countPrimes01();
        int i = countPrimes01.countPrimes1(5000000);
        System.out.println(i);
    }

    public int countPrimes(int n) {
        if(n == 1 || n == 0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        int temp;
        for (int i = 2; i < n; i++) {
            flag = true;
            if(i == 2) {
                list.add(i);
                continue;
            }
            for (Integer integer : list) {
                if(i % integer == 0){
                    flag = false;
                    break;
                }
                if(integer * integer > i){
                    break;
                }
            }
            if(flag){
                list.add(i);
            }
        }
        System.out.println(list.toString());
        return list.size();
    }


    /**
     * 埃式筛
     * @param n
     * @return 小于n的质数的个数
     */
    public int countPrimes1(int n){
        int[] isPalindrome = new int[n];
        Arrays.fill(isPalindrome, 1);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if(isPalindrome[i] == 1){
                if(((long) i * i) < n){
                    for (int j = i * i; j < n; j += i) {
                        isPalindrome[j] = 0;
                    }
                }
                ans++;
            }
        }
        return ans;
    }
}
