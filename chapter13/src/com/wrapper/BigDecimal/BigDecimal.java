package com.wrapper.BigDecimal;

public class BigDecimal {
    public static void main(String[] args) {
        double pi = 3.1415926535514653165413214651616516;
        //会自动缩减位数
        System.out.println(pi);
        //当我们需要一个精度很高的数
        java.math.BigDecimal bigDecimal = new java.math.BigDecimal("1.5165456416514651561");
        System.out.println(bigDecimal);

        java.math.BigDecimal bigDecimal1 = new java.math.BigDecimal("4.21253165165156");

        System.out.println(bigDecimal.add(bigDecimal1));

        System.out.println(bigDecimal.divide(bigDecimal1, java.math.BigDecimal.ROUND_CEILING));

    }
}
