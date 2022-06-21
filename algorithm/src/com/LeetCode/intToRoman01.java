package com.LeetCode;

public class intToRoman01 {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static void main(String[] args) {

        intToRoman01 intToRoman01 = new intToRoman01();
        String regStr1 = intToRoman01.intToRoman(5);
        System.out.println(regStr1);
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num >= 1000){
            sb.append('M');
            num -= 1000;
        }
        while (num >= 500){
            if(num / 100 == 9){
                sb.append("CM");
                num -= 900;
                break;
            }
            sb.append('D');
            num -= 500;
        }
        while (num >= 100){
            if(num / 100 == 4){
                sb.append("CD");
                num -= 400;
                break;
            }
            sb.append('C');
            num -= 100;
        }
        while (num >= 50){
            if(num / 10 == 9){
                sb.append("XC");
                num -= 90;
                break;
            }
            sb.append('L');
            num -= 50;
        }
        while (num >= 10){
            if(num / 10 == 4){
                sb.append("XL");
                num -= 40;
                break;
            }
            sb.append('X');
            num -= 10;
        }
        while (num >= 5){
            if(num == 9){
                sb.append("IX");
                num -= 9;
                break;
            }
            sb.append("V");
            num -=5;
        }
        while (num > 0){
            if(num == 4){
                sb.append("IV");
                num -= 5;
                break;
            }
            sb.append("I");
            num -= 1;
        }
        return sb.toString();
    }
    public String intToRoman1(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }

}
