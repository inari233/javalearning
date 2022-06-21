package com.list_.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class exercise01 {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 11; i++) {
            list.add("hello" + i);
        }
        list.add(1,"tom");
        System.out.println(list.get(5));
        list.remove(5);

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
