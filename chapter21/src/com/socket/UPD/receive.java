package com.socket.UPD;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class receive {
    public static void main(String[] args) throws IOException {
        //1.创建一个datagramSocket对象，准备在9999端口接受数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构件一个datagramPacket对象，准备接受数据
        //在前面讲解UDP协议时说过，一个数据包最大是64k
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
        //3.调用接受方法准备接受数据
        //将通过网络传输的datagramPacket对象
        //填充到packet对象里
        //当有数据包发送到本机的9999端口时，就会收到数据，反之就会阻塞
        System.out.println("接受段A等待接收数据");
        socket.receive(datagramPacket);

        //4.可以把packet进行拆包并显示
        int length = datagramPacket.getLength();//实际接收到的数据长度
        byte[] data = datagramPacket.getData();//接收到的数据
        String s = new String(data, 0, length);
        System.out.println(s);


        byte[] bytes = "已经接受到数据over".getBytes(StandardCharsets.UTF_8);
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 9998);
        socket.send(datagramPacket1);

        //关闭端口
        socket.close();
        System.out.println("a端结束");

    }
}
