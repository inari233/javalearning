package com.file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileinputstream {
    public static void main(String[] args) {

    }
@Test
    public void m1(){
        String fileName = "e:\\hello.txt";
        int readDate = 0;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
            while((readDate = fileInputStream.read())  != -1){
                System.out.print((char) readDate);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


