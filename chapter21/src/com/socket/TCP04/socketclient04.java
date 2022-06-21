package com.socket.TCP04;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class socketclient04 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        String filePath = "e:\\c.png";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes = new byte[1024];
        int readLine = 0;
        while ((readLine = bufferedInputStream.read(bytes)) != -1){
            outputStream.write(bytes);
        }
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int readLine1 = 0;
        while ((readLine1 = inputStream.read(buf)) != -1){
            System.out.println(new String(buf, 0, readLine1));
        }

        inputStream.close();
        outputStream.close();
        bufferedInputStream.close();
        socket.close();


    }
}
