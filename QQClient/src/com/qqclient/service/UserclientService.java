package com.qqclient.service;

import com.qqcommon.MessTye;
import com.qqcommon.Message;
import com.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 该类完成用户登录验证和用户注册等功能
 */

public class UserclientService {

    //因为可能在其他地方会使用这个属性
    private User user = new User();

    private Socket socket;



    //验证用户是否有效
    public boolean checkUser(String userId, String pwd) throws IOException, ClassNotFoundException {

        boolean b = false;
        //创建User对象
        user.setUserId(userId);
        user.setPasswd(pwd);
        //连接客户端
        socket = new Socket(InetAddress.getLocalHost(), 9999);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(user);//

        //从客户端读取服务器回复的message对象
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        Message ms = (Message) ois.readObject();


        //接口里的属性自动就是final static
        if (ms.getMessType().equals(MessTye.MESSAGE_LOGIN_SUCCEED)){//表示登录成功


            //准备创建一个和服务器端保持通信的线程->创建一个线程类 ClientConnectServerThread
            //
            ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
            clientConnectServerThread.start();
            //为了客户端扩展，将其放入到一个集合中
            ManageClientConnectServer.addClientConnectServerThread(userId, clientConnectServerThread);
            b = true;
        } else {
            //如果登录失败，就启动不了,就关闭socket
            socket.close();

        }

        return b;
    }

    //向服务器端请求在线列表
    public void onlineFriendList(){
        //发送一个得到MESSAGE
        Message message = new Message();
        message.setMessType(MessTye.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(user.getUserId());

        //发送给服务器
        //得到当前socket的流
        try {
            //得到userid对应的线程对象，在得到该线程对象里的socket
            //最后再通过该socket得到ObjectOutputStream对象
            //再将包装好的message发送给服务端
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServer.getClientConnectServerThread(user.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //编写方法退出客户端，并给服务端发送
    public void logout(){
        Message message = new Message();
        message.setMessType(MessTye.MESSAGE_CLIENT_EXIT);
        message.setSender(user.getUserId());//指定需要退出的客户端

        //发送message
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(user.getUserId() + "退出了系统");
            System.exit(0);//结束进程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
