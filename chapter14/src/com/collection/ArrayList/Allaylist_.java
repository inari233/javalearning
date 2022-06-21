package com.collection.ArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示collection接口的常用方法
 */

public class Allaylist_ {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        //add：添加单个元素
        arrayList.add(123);
        arrayList.add("jack");
        arrayList.add(true);
        System.out.println(arrayList);
        //remove:删除指定元素
        arrayList.remove(0);//删除第一个元素
        arrayList.remove("jack");
        System.out.println(arrayList);
        //contains：查找元素是否存在
        System.out.println(arrayList.contains(true));
        //size:获取元素个数
        System.out.println(arrayList.size());
        //isEmpty:判读是否为空
        //clear：清空
        //addall：添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("三国演义");
        arrayList.addAll(list2);
        System.out.println(arrayList);
        System.out.println(arrayList.containsAll(list2));

    }
}
