package com.exercise;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class exercise02 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("jack", 650);
        map.put("tom", 1200);
        map.put("smith", 2900);

        map.replace("jack", 2600);
        System.out.println(map);

        Set keyset = map.keySet();
        for (Object key : keyset) {
            map.put(key, (Integer)map.get(key) + 100);
        }
        System.out.println(map);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry)iterator.next();
            System.out.println(next.getKey() + "=" + next.getValue());

        }
    }
}
