package com.list_.exercise;

import java.util.ArrayList;
import java.util.List;

public class exercisr02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new bookname("sdf", "a6sdf", 644565));
        list.add(new bookname("sdf456", "as4df", 46045));
        list.add(new bookname("sdf4", "asd6f", 56405));
        list.add(new bookname("sdf654", "as4df", 5065));
        list.add(new bookname("sdf6", "asdf46", 50465));
        list.add(new bookname("sdf456", "as56df", 5404));

        for (Object o : list) {
            System.out.println(o);
        }
    }

}

class bookname{
    private String name;
    private String author;
    private double price;

    public bookname(String name, String author, double price) {
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
        return "名称：" + name + "\t\t价格" + price + "\t\t作者" + author;
    }
}
