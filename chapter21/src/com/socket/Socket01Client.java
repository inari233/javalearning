package com.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * 客户端发送信息给服务端
 */
public class Socket01Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器(ip, 端口)
        //解读，连接本机的9999端口，如果连接成功，返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //连接上后，通过socket.getOutputStream拿到相关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写入数据
        outputStream.write("hello,sever".getBytes(StandardCharsets.UTF_8));
        //关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
