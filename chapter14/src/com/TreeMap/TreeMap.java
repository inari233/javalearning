package com.TreeMap;

import java.util.Comparator;
import java.util.Map;

public class TreeMap {
    public static void main(String[] args) {
        Map treemap = new java.util.TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });

        treemap.put("tom", "汤姆");
        treemap.put("tom", "tyu");
        System.out.println(treemap);
    }
}
