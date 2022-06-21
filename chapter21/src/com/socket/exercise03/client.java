package com.socket.exercise03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        byte[] bytes = "src\\b.png".getBytes(StandardCharsets.UTF_8);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes, 0, bytes.length);
        socket.shutdownOutput();


        byte[] bytes1 = new byte[1024];
        int readLen = 0;
        InputStream inputStream = socket.getInputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("e:\\c.png"));
        while ((readLen = inputStream.read(bytes1)) != -1){
            bufferedOutputStream.write(bytes1);
        }




        bufferedOutputStream.close();
        outputStream.close();
        socket.close();



    }
}
