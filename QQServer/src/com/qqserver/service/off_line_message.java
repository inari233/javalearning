package com.qqserver.service;

import com.qqcommon.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public class off_line_message implements Runnable{
    public static HashMap<String, Vector<Message>> off_line_Message;
    private  HashMap<String, ServerConnectClientThread> hm;

    @Override
    public void run() {
        while (true){
            int i = 0;
            hm = ManageClientThread.getHm();
            off_line_Message = QQServer.off_line_Message;

            for (String s : off_line_Message.keySet()) {
                if (off_line_Message.containsKey(s)){
                    try {
                        Vector<Message> messages = off_line_Message.get(s);
                        for (Message message : messages) {
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(s).getSocket().getOutputStream());
                            oos.writeObject(message);
                        }
                        off_line_Message.remove(s);
                        break;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
