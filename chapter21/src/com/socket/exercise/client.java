package com.socket.exercise;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("name?");
        bufferedWriter.newLine();
        bufferedWriter.flush();




        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedWriter.write("hobby?");
        bufferedWriter.newLine();
        bufferedWriter.flush();


        String s1 = bufferedReader.readLine();
        System.out.println(s1);


        bufferedWriter.close();
        socket.close();
        bufferedReader.close();

    }
}
