package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> strings = fizzBuzz.fizzBuzz(15);
        System.out.println(strings.toString());
    }

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add(new String("FizzBuzz"));
            } else if (i % 3 == 0) {
                list.add(new String("Fizz"));
            } else if (i % 5 == 0) {
                list.add(new String("Buzz"));
            } else {
                list.add(new String(String.valueOf(i)));
            }
        }
        return list;

    }
}
