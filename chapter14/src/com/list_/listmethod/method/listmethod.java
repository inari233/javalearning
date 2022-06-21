package com.list_.listmethod.method;

import java.util.ArrayList;
import java.util.List;

public class listmethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("阿萨德");
        list.add("sdf");
        //在指定的索引位置插入元素
        list.add(1, "saddd");
        System.out.println(list);
        List list2 = new ArrayList();
        list2.add("阿萨德");
        list2.add("阿萨");
        list.addAll(1, list2);
        System.out.println(list);
        //获得指定索引的元素
        list.get(1);
        //返回对象在list里第一次出现的位置
        System.out.println(list.indexOf("sdf"));
        //返回对象在list里最后一次出现的位置
        System.out.println(list.lastIndexOf("阿萨"));
        //删除索引元素
        list.remove(0);
        //替换元素
        list.set(2, "mary");
        //返回子集前闭后开
        List newlist = list.subList(0, 2);

    }
}
