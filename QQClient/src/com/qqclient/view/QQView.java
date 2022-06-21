package com.qqclient.view;

import com.qqclient.service.FileClientService;
import com.qqclient.service.UserclientService;
import com.qqclient.service.messageClientService;
import com.qqclient.utility.Utility;

import java.io.IOException;

/**
 * 菜单界面
 */

public class QQView {

    private boolean loop = true;//控制是否显示菜单
    private String key = " ";//接受用户
    private UserclientService userclientService = new UserclientService();//用于登录服务器
    private messageClientService messageClientService = new messageClientService();
    private FileClientService fileClientService = new FileClientService();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new QQView().mainMenu();
    }


    //显示主菜单
    public void mainMenu() throws IOException, ClassNotFoundException {
        while (loop){
            System.out.println("=============欢迎登录网络通信系统=============");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.println("请输入你的选择：");
            key = Utility.readString(1);

            //根据用户的输入来处理不同的逻辑
            switch (key){
                case "1":
                    System.out.println("登录系统");
                    System.out.println("请输入用户号");
                    String userId = Utility.readString(50);
                    System.out.println("请输入密码");
                    String pwd = Utility.readString(50);
                    //需要到服务掉去验证该用户是否合法
                    if(userclientService.checkUser(userId, pwd)) {//先把逻辑打通
                        System.out.println("=============欢迎" + userId + "=============");
                        //进入到二级菜单
                        while(loop){
                            System.out.println("\n============网络通信系统二级菜单============");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.println("请输入你的选择：");
                            key = Utility.readString(1);

                            switch (key) {
                                case "1":
                                    //编写一个方法来获取在线用户列表
                                    System.out.println("显示在线用户列表");
                                    userclientService.onlineFriendList();
                                    break;
                                case "2":
                                    System.out.println("群发消息");
                                    System.out.println("请输入相对大家说的话");
                                    String s = Utility.readString(100);
                                    //调用一个方法将这个方法发送
                                    messageClientService.sendMessageToAll(s, userId);
                                    break;
                                case "3":
                                    System.out.println("私聊信息");
                                    System.out.println("请输入想聊天的用户名（在线）:");
                                    String getterId = Utility.readString(50);
                                    System.out.println("请输入想说的话");
                                    String content = Utility.readString(100);
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    break;
                                case "4":
                                    System.out.println("发送文件");
                                    System.out.println("请输入你想发送文件的用户");
                                    getterId = Utility.readString(50);
                                    System.out.println("请输入发送文件的路径（e:\\xx.jpg）");
                                    String src = Utility.readString(100);
                                    System.out.println("请输入你要发送到对方的路径");
                                    String dest = Utility.readString(50);
                                    fileClientService.sendFileToOne(src, dest, userId, getterId);
                                    break;
                                case "9":
                                    System.out.println("退出系统");
                                    //调用方法
                                    userclientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登陆失败");
                    }
                    break;
                case"9":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }
}
