package com.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Bufferwriter {
    public static void main(String[] args) {
        String destPath = "e:\\b.txt";
        String str = "hello, ysh";
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(destPath));
            bufferedWriter.write(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
