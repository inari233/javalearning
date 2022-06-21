package com.hashset;

import com.set.set;

import java.util.HashSet;
import java.util.Set;

/**
 * hashset的底层还是hashmap
 * 可以存放null,但是只能有一个null
 * hashmap就是数组加链表，每个数组的元素里存储着链表的头节点
 * 判断元素是否相同是通过equals进行比较的
 */
public class hashset {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add(new String("tom"));
        set.add(new String("tom"));

        String s1 = new String("tom");
        String s2 = new String("tom");
        System.out.println(s1 == s2);

    }
}
