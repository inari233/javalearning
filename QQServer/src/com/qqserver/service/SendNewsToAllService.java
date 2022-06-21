package com.qqserver.service;

import com.Utility.Utility;
import com.qqcommon.MessTye;
import com.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class SendNewsToAllService implements Runnable{

    @Override
    public void run() {

        while (true) {
            System.out.println("请输入服务器要推送的新闻, 输入exit表示退出推送服务");
            String news = Utility.readString(100);
            if (news.equals("exit")){
                break;
            }
            Message message = new Message();
            message.setSender("服务器");
            message.setContent(news);
            message.setMessType(MessTye.MESSAGE_TO_ALL_MESSAGE);
            message.setSendTime(new Date().toString());
            System.out.println("服务器推送消息给所有人说：" + news);

            //遍历当前所有的推送线程
            HashMap<String, ServerConnectClientThread> hm = ManageClientThread.getHm();

            for (String s : hm.keySet()) {
                try {
                    OutputStream os = hm.get(s).getSocket().getOutputStream();
                    ObjectOutputStream oos = new ObjectOutputStream(os);
                    oos.writeObject(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
