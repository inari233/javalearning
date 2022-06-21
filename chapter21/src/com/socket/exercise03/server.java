package com.socket.exercise03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();


        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String filename = bufferedReader.readLine();
        System.out.println(filename);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filename));

        byte[] bytes = new byte[1024];
        int readLen = 0;
        while ((readLen = bufferedInputStream.read(bytes)) != -1){
            outputStream.write(bytes, 0, readLen);
        }
        socket.shutdownOutput();

        bufferedInputStream.close();
        bufferedReader.close();
        outputStream.close();
        socket.close();
        serverSocket.close();

    }
}
