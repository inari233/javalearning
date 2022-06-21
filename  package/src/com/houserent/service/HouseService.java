package com.houserent.service;

import com.houserent.domain.House;

/**
 * 业务层
 */
public class HouseService {

    private House[] houses;//保存House对象
    private int house_Numbers = 0;//记录当前有多少个房屋信息
    private int idCount = 0;//id自增长计数器

    public HouseService(int size) {
        //new house
        houses = new House[size];
        //houses [0] = new House(1, "jack", "1332","北京", 5000, "已出租");
    }
    //list方法返回所有的房屋信息
    public House[] list(){
        return houses;
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newhouse){
        //暂时不考虑数组扩容的问题
        if(house_Numbers == houses.length){
            System.out.println("数组已满不能在添加了");
            return false;
        }
        //把newhouse对象加入到
        houses[house_Numbers++] = newhouse;
        //我们程序员需要一个id自增长机制
        newhouse.setId(++idCount);
        return true;
    }

    public boolean del(int delId){
        //找到要删除的房屋信息对应的下标
        //一定要搞清楚房屋的
        int index = -1;
        for (int i = 0; i < house_Numbers; i++) {
            if(delId == houses[i].getId()){
                index = i;//记录id
            }
        }
        if(index == -1){
            return false;
        }
        //找到如何删除
        for (int i = index; i < house_Numbers - 1; i++) {
            houses[i] = houses[i + 1];
            houses[i].setId(i + 1);
        }
        houses[--house_Numbers] = null;
        idCount--;

        return true;
    }

    public House find(int id){
        if(id > idCount){
            return null;
        }
        return houses[id - 1];
    }

    public boolean amend(House amend_house,int amend_id){
        if(amend_id > house_Numbers){
            return false;
        }
        houses[amend_id - 1] = amend_house;
        return true;

    }
}
