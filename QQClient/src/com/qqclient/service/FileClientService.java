package com.qqclient.service;

import com.qqcommon.MessTye;
import com.qqcommon.Message;

import java.io.*;

/**
 * 该类完成文件传输服务
 */
public class FileClientService {
    public void sendFileToOne(String src, String dest, String sendId, String getterId){
        //读取src文件
        Message message = new Message();
        message.setMessType(MessTye.MESSAGE_FILE_MES);
        message.setSender(sendId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        //需要将文件进行读取
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        byte[] bytes = new byte[(int) new File(src).length()];

        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(bytes);
            //将数组设计到message
            message.setFileByes(bytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("\n" + message.getSender() + "给" + getterId + "发送文件" + src + "到对方的" +
                dest);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    ManageClientConnectServer.getClientConnectServerThread(sendId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
