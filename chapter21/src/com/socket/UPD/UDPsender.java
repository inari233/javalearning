package com.socket.UPD;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPsender {
    public static void main(String[] args) throws IOException {
        //创建一个datagramSocket对象，准备接受和发送数据
        //准备在9998端口接受和发送数据
        DatagramSocket socket = new DatagramSocket(9998);

        //2.将需要发送的数据装包
        byte[] bytes = "hello,明天吃火锅".getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);

        socket.send(datagramPacket);

        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(buf, buf.length);
        socket.receive(datagramPacket1);
        int length = datagramPacket1.getLength();
        byte[] buf1 = datagramPacket1.getData();
        String s = new String(buf1, 0, length);
        System.out.println(s);


        socket.close();
        System.out.println("b端结束");
    }
}
