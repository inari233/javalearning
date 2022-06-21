package com.socket.exercise02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class receiveA {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

        System.out.println("A端口正在接受数据");
        socket.receive(datagramPacket);

        int length = datagramPacket.getLength();
        byte[] bytes1 = datagramPacket.getData();
        String s = new String(bytes1, 0, length);
        System.out.println(s);

        byte[] bytes2 = "四大名著是《红楼梦》...".getBytes(StandardCharsets.UTF_8);
        byte[] bytes3 = "what".getBytes(StandardCharsets.UTF_8);

        DatagramPacket datagramPacket1 = new DatagramPacket(bytes2, bytes2.length, InetAddress.getLocalHost(), 9998);
        DatagramPacket datagramPacket2 = new DatagramPacket(bytes3, bytes3.length, InetAddress.getLocalHost(), 9998);
        if (s.equals("四大名著是那些?")) {
            socket.send(datagramPacket1);
        } else {
            socket.send(datagramPacket2);
        }


        socket.close();
    }
}
