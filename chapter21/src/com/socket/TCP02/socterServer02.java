package com.socket.TCP02;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class socterServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = inputStream.read(bytes)) != -1){
            System.out.println(new String(bytes, 0, readLen));
        }
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("hello, client".getBytes(StandardCharsets.UTF_8));
        //设置结束标记
        accept.shutdownOutput();




        outputStream.close();
        inputStream.close();
        serverSocket.close();
        accept.close();
    }
}
