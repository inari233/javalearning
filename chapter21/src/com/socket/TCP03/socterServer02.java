package com.socket.TCP03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class socterServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
//        byte[] bytes = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(bytes)) != -1){
//            System.out.println(new String(bytes, 0, readLen));
//        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);


        OutputStream outputStream = accept.getOutputStream();
//        outputStream.write("hello, client".getBytes(StandardCharsets.UTF_8));
//        //设置结束标记
//        accept.shutdownOutput();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        outputStream.close();
        inputStream.close();
        serverSocket.close();
        accept.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
