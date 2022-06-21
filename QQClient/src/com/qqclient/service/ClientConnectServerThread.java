package com.qqclient.service;

import com.qqcommon.MessTye;
import com.qqcommon.Message;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Arrays;

public class ClientConnectServerThread extends Thread {
    //必须持有socket
    private Socket socket;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("客户端线程等待从服务端发送的信息");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();


                //判断该message的类型，再进行相应的业务处理
                //如果读取到的是相应的服务器发送的在线用户列表
                if (message.getMessType().equals(MessTye.MESSAGE_RET_ONLINE_FRIEND)) {
                    //取出在线列表信息
                    /**
                     * 规定返回给客户端的在线用户名单用空格分割
                     */
                    String[] s = message.getContent().split(" ");
                    System.out.println("\n========当前在线用户列表========");
                    for (String s1 : s) {
                        System.out.println("用户：" + s1);
                    }
                } else if (message.getMessType().equals(MessTye.MESSAGE_COMM_MES)) {
                    //把从服务器端转发的消息，显示到控制台即可
                    System.out.println("\n" + message.getSender() + "对" +
                            message.getGetter() + "说" + message.getContent());
                } else if (message.getMessType().equals(MessTye.MESSAGE_TO_ALL_MESSAGE)) {
                    //显示在客户端的控制台即可
                    System.out.println("\n" + message.getSender() + "对大家说" + message.getContent());
                } else if (message.getMessType().equals(MessTye.MESSAGE_FILE_MES)) {
                    System.out.println("\n" + message.getSender() + "给" + message.getGetter() + "发送文件到"
                     + message.getDest());

                    FileOutputStream fileOutputStream = new FileOutputStream(message.getDest());
                    fileOutputStream.write(message.getFileByes());
                    fileOutputStream.close();
                    System.out.println("保存文件成功");
                } else {
                    System.out.println("是其他类型的message占卜处理");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
