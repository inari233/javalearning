package com.qqserver.service;

import com.qqcommon.MessTye;
import com.qqcommon.Message;
import com.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Vector;

/**
 * 服务端，监听端口，等待客户端的连接，并保持通讯
 */
public class QQServer {

    private ServerSocket ss = null;
    //使用集合,创建一个集合存放多个用户，如果是这些用户登录，就认为是合法的
    private static HashMap<String, User> validUser = new HashMap<>();
    public static HashMap<String, Vector<Message>> off_line_Message = new HashMap<>();

    static {//在静态代码块初始化一次
        validUser.put("100", new User("100", "123456"));
        validUser.put("200", new User("200", "123456"));
        validUser.put("300", new User("300", "123456"));
        validUser.put("至尊宝", new User("至尊宝", "123456"));
        validUser.put("紫霞仙子", new User("紫霞仙子", "123456"));
        validUser.put("菩提老祖", new User("菩提老祖", "123456"));

    }

    //验证用户是否有效的方法
    private boolean checkUser(String userid, String passwd){
        User user = validUser.get(userid);
        if(user == null) {//说明没有存在该用户
            return false;
        }
        if(!user.getPasswd().equals(passwd)){
            return false;
        }
        return true;
    }



    public QQServer() {
        //端口可以写在一个配置文件中
        try {
            System.out.println("服务器在监听");
            //启动推送线程的线程
            new Thread(new SendNewsToAllService()).start();
            ss = new ServerSocket(9999);

            while (true) {//监听是当和某个客户端建立连接后会一直监听
                Socket socket = ss.accept();

                //等到socket对象的输入流
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                //得到socket对象的输出流
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                User u = (User) ois.readObject();//读取客户端发送的User对象
                //创建一个message对象，准备回复客户端
                Message message = new Message();
                if (checkUser(u.getUserId(), u.getPasswd())){
//                    if (off_line_Message.containsKey(u.getUserId())){
//                        HashMap<String, Message> hm = off_line_Message;
//                        Message message1 = hm.get(u.getUserId());
//                        oos.writeObject(message1);
//                    }
                    //合法用户
                    message.setMessType(MessTye.MESSAGE_LOGIN_SUCCEED);
                    //将Message对象回复
                    oos.writeObject(message);
                    //创建一个线程，和客户端保持通信,该线程需要持有socket对象
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(socket, u.getUserId());
                    //启动线程
                    serverConnectClientThread.start();
                    //把该线程对象放入到一个集合中集中管理
                    ManageClientThread.addClientThread(u.getUserId(), serverConnectClientThread);
                    Thread.sleep(1000);
                    if (off_line_Message.containsKey(u.getUserId())){
                        System.out.println("有离线信息");
                        //HashMap<String, Message> hm = off_line_Message;
                        //Message message1 = hm.get(u.getUserId());
                        //oos.writeObject(message1);
                        new Thread(new off_line_message()).start();
                    }

                } else {
                    //登录失败
                    System.out.println("id=" + u.getUserId() + "pwd=" + u.getPasswd() + "验证失败");
                    //message.setMessType(MessTye.MESSAGE_LOGIN_FAIL);
                    //oos.writeObject(message);
                    //关闭socket
                    //socket.close();
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //如果客户端退出了循环，说明服务器不在监听
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
