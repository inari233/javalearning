package com.qqcommon;

import java.io.Serializable;

/**
 * 表示客户端和服务端通信的消息对象
 */

public class Message implements Serializable {
    private String sender;//发送者
    private String getter;//接受者
    private String content;//消息内容
    private String sendTime;//发送消息时间
    private String messType;//消息类型【可以在接口中定义消息类型】
    private static final long serialVersionUID = 1L;

    //进行拓展，增加和文件相关的成员
    private byte[] fileByes;
    private int fileLen;
    private String dest;//文件传输的目的地
    private String src;//源文件路径

    public byte[] getFileByes() {
        return fileByes;
    }

    public void setFileByes(byte[] fileByes) {
        this.fileByes = fileByes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
