package com.socket.TCP03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class sockerclient02 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        OutputStream outputStream = socket.getOutputStream();
        //outputStream.write("hello, sever".getBytes(StandardCharsets.UTF_8));
        //要求使用字符流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello,server 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();//需要手动刷新
        //socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();

//        byte[] bytes = new byte[1024];
//        int readLen = 0;
//        while ((readLen = inputStream.read(bytes)) != -1){
//            System.out.println(new String(bytes, 0, readLen));
//        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        outputStream.close();
        socket.close();
        inputStream.close();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
