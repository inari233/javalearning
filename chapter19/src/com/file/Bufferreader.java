package com.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Bufferreader {
    public static void main(String[] args) {
        String filePath = "e:\\a.txt";
        BufferedReader bufferedReader = null;
        String readDate;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            if((readDate = bufferedReader.readLine()) != null){
                System.out.println(readDate);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
