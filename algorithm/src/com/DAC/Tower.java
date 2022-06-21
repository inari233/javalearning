package com.DAC;

public class Tower {
    public static void main(String[] args) {
        hanoi_tower(4, 'a', 'b', 'c');
    }

    public static void hanoi_tower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + "->" + c);
        } else {
            hanoi_tower(num - 1, a, c, b);
            System.out.println(a + "->" + c);
            hanoi_tower(num - 1, b, a, c);
        }
    }
}
