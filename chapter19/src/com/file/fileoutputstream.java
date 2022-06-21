package com.file;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class fileoutputstream {
    public static void main(String[] args) {

    }
    @Test
    public void m4(){
        String filePath ="e:\\a.txt";
        FileOutputStream fileOutputStream = null;

        try {
            /**
             * 该方法会覆盖原有的文件FileOutputStream(filePath)
             * new FileOutputStream(filePath, true)则会追加
             */
            fileOutputStream = new FileOutputStream(filePath);
            //fileOutputStream.write('a');
            String str = "hello,world";
            //该方法可以把一个字符串转化成字节数组
            //fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            //该方法写入特定数组索引
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8), 0, 8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
