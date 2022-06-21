package com.file;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class exercise01 {
    public static void main(String[] args) {
        String str = "e:\\c.txt";
        BufferedReader bufferedReader = null;
        String readLine = " ";
        int line = 1;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str), "gbk"));
            while ((readLine = bufferedReader.readLine()) != null){
                System.out.println("第" + (line++) + "行的内容是" + readLine );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
