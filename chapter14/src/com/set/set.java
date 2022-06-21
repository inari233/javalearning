package com.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set是无序且不重复的
 * set对象存放数据是无需的（即添加的顺序和取出的顺序是不同的）
 * 但是取出的顺序是不变的
 */

public class set {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("lucy");
        set.add("lucy1");
        set.add("lucy2");
        set.add("lucy3");
        set.add("lucy4");
        set.add("lucy5");
        set.add("lucy9");

        //可以使用迭代器和增强for循环来遍历
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        for (Object o : set) {
            System.out.println(o);
        }
    }
}
