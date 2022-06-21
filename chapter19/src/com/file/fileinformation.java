package com.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class fileinformation {
    public static void main(String[] args) {

    }

    @Test
    public void info() {
        //先创建文件对象
        File file = new File("e:\\news1.txt");
        System.out.println(file.getName());//相对路径
        System.out.println(file.getAbsoluteFile());//绝对路径
        System.out.println(file.getParent());//文件父级目录
        System.out.println(file.length());//文件大小（字节）
        System.out.println(file.exists());//文件是否存在
        System.out.println(file.isDirectory());//文件是不是路径


    }
}
