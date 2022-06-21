package com.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 演示INetAddress类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的INetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //根据指定主机名，获取INetAddress对象
        InetAddress host1 = InetAddress.getByName("LAPTOP-BN6GKSQS");
        System.out.println(host1);

        //根据域名返回INetAddress对象
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println(host2);

        //通过INetAddress对象，反向获取对应的地址
        String host3 = host2.getHostAddress();
        System.out.println(host3);

        //通过INetAddress对象，返回对应的主机名或域名
        String host4 = host2.getHostName();
        System.out.println(host4);
    }
}
