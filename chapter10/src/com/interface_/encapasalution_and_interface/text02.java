package com.interface_.encapasalution_and_interface;

/**
 * 接口的多态
 */
public class text02 {
    public static void main(String[] args) {
        IF i = new monster();
        i = new cat();
    }

}

interface IF{}

class monster implements IF{}

class cat implements IF{}
