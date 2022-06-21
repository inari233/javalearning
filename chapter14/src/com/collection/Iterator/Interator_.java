package com.collection.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Interator_ {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 12.2));
        col.add(new Book("三国演", "罗贯", 12.22));
        col.add(new Book("三国", "罗", 12.26));

        //使用迭代器来遍历
        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {//判断是否还有数据
            //返回下一个元素，类型是obj
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //快捷键 while -> itit
        //cult + j

        //当循环退出后，这是迭代器已经指向了最后一个元素
        //在用next（）取会抛出null异常
        //当希望再次遍历，需要充值迭代器
        iterator = col.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }


    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}