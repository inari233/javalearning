package com.wrapper.BigInteger_;

import java.math.BigInteger;

public class Big {
    public static void main(String[] args) {
        BigInteger bigInteger = new BigInteger("3211111111111111122222222222222222222223");
        System.out.println(bigInteger);

        //bigInteger自带加法
        BigInteger bigInteger1 = new BigInteger("445666666666666666666664");
        BigInteger bigInteger2 = bigInteger.add(bigInteger1);
        System.out.println(bigInteger2);
    }
}
