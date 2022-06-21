package com.enum_.exercise04;

class test {
    public static void main(String[] args) {
        new A().hi();
    }
}

public class A {
    private String NAME = "sa";

    public void hi() {
        class B {
            private final String NAME = "sf";

            public void getName() {
                System.out.println(NAME);
            }
        }
        new B().getName();
    }
}
