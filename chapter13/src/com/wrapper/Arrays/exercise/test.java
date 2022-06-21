package com.wrapper.Arrays.exercise;

import java.util.Arrays;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 5);
        books[3] = new Book("java从入门到放弃", 300);

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (int)(o1.getPrice() - o2.getPrice());
            }
        });

        System.out.println(Arrays.toString(books));


        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(Arrays.toString(books));

    }
}
