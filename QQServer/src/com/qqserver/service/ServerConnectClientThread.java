package com.qqserver.service;

import com.qqcommon.MessTye;
import com.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

/**
 * 该类对应的对象和客户端保持通讯
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;//连接到服务端的用户id

    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {//这里线程处于一个run状态，可以发送.接受消息
        while (true) {
            try {
                System.out.println("服务端和客户端" + userId + "保持通信，读取数据");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                //使用message，根据message类型，做相应的业务处理
                if (message.getMessType().equals(MessTye.MESSAGE_GET_ONLINE_FRIEND)) {
                    //客户端要在线用户列表
                    System.out.println(message.getSender() + "要在线用户列表");
                    String onlineList = ManageClientThread.getOnlineList();
                    //准备输出到客户端
                    //构建一个message对象,包含了在线用户列表信息
                    Message message1 = new Message();
                    message1.setMessType(MessTye.MESSAGE_RET_ONLINE_FRIEND);
                    message1.setContent(onlineList);
                    message1.setGetter(message.getSender());
                    //写入到数据通道
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message1);
                    oos.writeObject(message1);

                } else if (message.getMessType().equals(MessTye.MESSAGE_CLIENT_EXIT)) {
                    System.out.println(message.getSender() + "要退出客户端");
                    //将这个客户端对应的线程从集合中删除
                    ManageClientThread.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭线程
                    //退出while
                    break;
                } else if (message.getMessType().equals(MessTye.MESSAGE_COMM_MES)) {


                    if (!ManageClientThread.getHm().containsKey(message.getGetter())) {
                        System.out.println("用户不在线");
                        if (QQServer.off_line_Message.containsKey(message.getGetter())) {
                            QQServer.off_line_Message.get(message.getGetter()).add(message);
                        } else {
                            Vector<Message> messages = new Vector<>();
                            messages.add(message);
                            QQServer.off_line_Message.put(message.getGetter(), messages);
                        }
                    } else {
                        //更具message的id，得到对应的线程
                        ServerConnectClientThread serverConnectClientThread = ManageClientThread.getServerConnectClientThread(message.getGetter());
//                    if(serverConnectClientThread == null){
//                        System.out.println("用户不在线");
//                        break;
//                    }
                        //得到该线程对应的socket的对象输出流，再转发给指定的对象
                        ObjectOutputStream oos = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                        oos.writeObject(message);
                    }
                } else if (message.getMessType().equals(MessTye.MESSAGE_TO_ALL_MESSAGE)) {
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThread.getHm();
                    Set<String> strings = hm.keySet();
                    for (String string : strings) {
                        //取出在线用户的id
                        if (!string.equals(message.getSender())) {
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(string).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                    }
                } else if (message.getMessType().equals(MessTye.MESSAGE_FILE_MES)) {
                    //直接转发message
                    if (!ManageClientThread.getHm().containsKey(message.getGetter())) {
                        System.out.println("用户不在线");
                        if (QQServer.off_line_Message.containsKey(message.getGetter())) {
                            QQServer.off_line_Message.get(message.getGetter()).add(message);
                        } else {
                            Vector<Message> messages = new Vector<>();
                            messages.add(message);
                            QQServer.off_line_Message.put(message.getGetter(), messages);
                        }
                    } else {
                        OutputStream os = ManageClientThread.getServerConnectClientThread(message.getGetter()).getSocket().getOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(os);
                        oos.writeObject(message);
                    }
                } else {
                    System.out.println("其它类型的暂时不处理");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
            }

        }

    }

    public Socket getSocket() {
        return socket;
    }
}
