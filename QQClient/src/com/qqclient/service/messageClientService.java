package com.qqclient.service;

import com.qqcommon.MessTye;
import com.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 该对象是提供和消息相关的
 */
public class messageClientService {
    public void sendMessageToOne(String content, String senderId, String getterId){
        //构建Message
        Message message = new Message();
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setMessType(MessTye.MESSAGE_COMM_MES);
        message.setSendTime(new Date().toString());
        System.out.println(senderId + "对" + getterId + "说" + content);
        //准备发送非服务端
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServer.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessageToAll(String content, String senderId){
        Message message = new Message();
        message.setSender(senderId);
        message.setContent(content);
        message.setMessType(MessTye.MESSAGE_TO_ALL_MESSAGE);
        message.setSendTime(new Date().toString());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServer.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
