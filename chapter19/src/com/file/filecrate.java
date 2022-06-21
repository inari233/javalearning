package com.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 演示创建文件
 */

public class filecrate {
    public static void main(String[] args) {

    }

    //方式一，new File(String pathname)
    @Test
    public void crate01(){
        String filePath = "e:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("文件创建成功");
    }

    //方式二
    @Test
    public void crate02(){
        File parentFile = new File("e:\\");
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式三
    @Test
    public void crate03(){
        String parentPath = "e:\\";
        String filePath = "mews03.txt";
        File file = new File(parentPath, filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
