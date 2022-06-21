package com.qqserver.service;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 该类用于管理和客户端通讯的线程
 */
public class ManageClientThread {
    private static HashMap<String, ServerConnectClientThread> hm = new HashMap<>();

    //添加
    public static void addClientThread(String userId, ServerConnectClientThread serverConnectClientThread){

        hm.put(userId, serverConnectClientThread);

    }

    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    //编写方法返回在线用户列表
    public static String getOnlineList(){
        //遍历集合，遍历hashmap的key
        Iterator<String> iterator = hm.keySet().iterator();

        StringBuilder onLineUserList = new StringBuilder("");

        for (String s : hm.keySet()) {
            onLineUserList.append(s).append(" ");
        }
        return onLineUserList.toString();
    }

    //移除对象线程的方法
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }
}
