package com.collection.plusfor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class plusfor {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book3("三国演义", "罗贯中", 12.2));
        col.add(new Book3("三国演", "罗贯", 12.22));
        col.add(new Book3("三国", "罗", 12.26));

        //快捷键iter 或I，col.iter,col.for
        //增强for也可以在数组上使用

        for (Object o : col) {
            System.out.println(o);
        }


    }
}

class Book3 {
    private String name;
    private String author;
    private double price;

    public Book3(String name, String author, double price) {
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
    

