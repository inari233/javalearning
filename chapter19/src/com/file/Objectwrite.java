package com.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Objectwrite {
    public static void main(String[] args) {
        String destPath = "e:\\c.dat";
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(destPath));
            System.out.println(objectInputStream.readInt());
            System.out.println(objectInputStream.readUTF());
            /**
             * 对类进行反序列化时要先把类先拿到
             */
            Object o = objectInputStream.readObject();
            System.out.println(o.getClass());
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
