package com.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 类的静态方法和transient方法不会进行序列化
 * 序列化对象时，需要里面的属性也能进行序列化
 */
public class Objectread {
    public static void main(String[] args) {
        String filePath = "e:\\c.dat";
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeInt(100);
            objectOutputStream.writeUTF("asd");
            objectOutputStream.writeObject(new Dog("小黄", 3));
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }




    }
}

class Dog implements Serializable{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
