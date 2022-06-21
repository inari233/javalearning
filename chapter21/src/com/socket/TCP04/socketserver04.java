package com.socket.TCP04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class socketserver04 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = new byte[1024];
        int readLine = 0;
        String destPath = "src\\a.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath));

        while ((readLine = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes);
        }


        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(("收到图片").getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();

        outputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
