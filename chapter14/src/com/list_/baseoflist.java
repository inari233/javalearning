package com.list_;

import java.util.ArrayList;
import java.util.List;

public class baseoflist {
    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println(list);
        }

        for (int i = 11; i < 20; i++) {
            list.add(i);
            System.out.println(list);
        }
    }
}
