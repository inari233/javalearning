package com.list_.listmethod;

import java.util.ArrayList;
import java.util.List;

public class list_ {
    public static void main(String[] args) {
        List list = new ArrayList();
        //list里的元素是有序的（即添加循序和取出顺序一样）,且可重复
        list.add("tom");
        list.add("123");
        list.add("jack");
        list.add("12");
        list.add("12");
        System.out.println(list);
        //list里的每个元素都有其对应的索引，支持索引，从0开始
    }
}
