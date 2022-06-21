package com.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class socketTCP01Server {
    public static void main(String[] args) throws IOException {
        //1.在本机的9999端口监听
        //细节，要求在本机没有其它服务再占用9999端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听，等待连接");
        //当没有客户端连接9999端口时，程序就阻塞，等待连接
        //如果有客户端连接，就会返回socket对象，程序继续
        Socket socket = serverSocket.accept();


        System.out.println("服务端scoket" + socket);

        //获取输入流
        InputStream inputStream = socket.getInputStream();
        //io读取
        byte[] buf = new byte[1024];
        int readLen = 0;

        while ((readLen = inputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, readLen));
        }

        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
