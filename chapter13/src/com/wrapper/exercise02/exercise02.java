package com.wrapper.exercise02;

import java.util.Scanner;

public class exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            try {
                System.out.println("请输入用户名");
                String name = scanner.next();
                if(!(name.length() == 2 || name.length() == 3 || name.length() == 4)){
                    throw new RuntimeException("用户名长度必须为2或3或4");
                }
                System.out.println("请输入密码");
                int password = scanner.nextInt();
                if(!(password > 99999 && password < 1000000)){
                    throw new RuntimeException("密码必须为6位数");
                }
                System.out.println("请输入邮箱");
                String mail = scanner.next();
                if(!(mail.indexOf('@') < mail.indexOf('.') || mail.indexOf('@') != -1 || mail.indexOf('.') != -1)){
                    throw new RuntimeException("必须包含@和.并且@要在.后");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                break;
            }
             loop = false;
        }

    }
}
