package com.map;

import java.util.*;

/**
 * map的key不能重复，但是value可以
 * 常用字符串做key，但其他任意类型也可以
 * 可以用map的key值得到其value值
 * key可以是null，但是只能有一个
 */
@SuppressWarnings({"all"})
public class map_ {
    public static void main(String[] args) {
        Map map = new HashMap();
        //添加元素
        map.put("no1", "小胡");
        map.put("no2", "小胡");
        //  可以取出所有的key
        /**
         * 第一种
         */
        Set keyset = map.keySet();
        for (Object o : keyset) {
            System.out.println(o);
        }
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }
        // 可以使用所有的遍历方法，即三种
        /**
         * 第二种
         */
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object next = iterator1.next();
            System.out.println(next);
        }
        /**
         * 第三种
         */

        Set set = map.entrySet();
        //1.增强for
        for (Object o : set) {
            Map.Entry m = (Map.Entry) o;
            System.out.println(m.getKey() + "=" + m.getValue());
        }

        Iterator iterator2 = set.iterator();
        while (iterator2.hasNext()) {
            Object next = iterator2.next();
            //这个时候next是Object类的,Node是实现了entry接口的类型，但是Node没有权限访问，所以可以直接
            //转成Map.Entry,再使用getKey,getValue
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getValue());

        }


        System.out.println(map.get("no1"));
    }
}
