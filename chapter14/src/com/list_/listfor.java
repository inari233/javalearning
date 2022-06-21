package com.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class listfor {
    public static void main(String[] args) {
        List list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add("tome" + i);
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object s = iterator.next();
            System.out.println(s);
        }

        for (Object o : list) {
            System.out.println(o);
        }


    }
}
