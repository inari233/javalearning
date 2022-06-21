package com.socket.exercise;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println(s);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("我是nova");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        String s1 = bufferedReader.readLine();
        System.out.println(s1);

        bufferedWriter.write("java");
        bufferedWriter.newLine();
        bufferedWriter.flush();




        bufferedReader.close();
        serverSocket.close();
        bufferedWriter.close();
        socket.close();


    }
}
