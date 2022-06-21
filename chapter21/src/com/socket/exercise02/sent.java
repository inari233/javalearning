package com.socket.exercise02;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class sent {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] bytes = "四大名著是那些?".getBytes(StandardCharsets.UTF_8);

        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9999);

        socket.send(datagramPacket);

        byte[] bytes1 = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);

        socket.receive(datagramPacket1);

        int length = datagramPacket1.getLength();
        byte[] bytes2 = datagramPacket1.getData();
        String s1 = new String(bytes2, 0, length);
        System.out.println(s1);
    }
}
