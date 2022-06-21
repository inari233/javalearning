package com.LeetCode;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 */
public class plusOne {
    public static void main(String[] args) {
        int[] digits = {9, 9, 9,9};
        int[] ints = plusOne1(digits);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }

    public static int[] plusOne1(int[] digits) {
        int num = 10;
        int i = digits.length - 1;
        while (true){
            num = digits[i] + 1;
            if(num == 10 && i > 0){
                digits[i] = 0;
                i--;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        if(digits[0] == 10){
            int[] newArray = new int[digits.length + 1];
            if (digits.length - 2 >= 0) System.arraycopy(newArray, 2, newArray, 3, digits.length - 2);
            newArray[0] = 1;
            newArray[1] = 0;
            return newArray;
        } else {
            return digits;
        }
    }
}
