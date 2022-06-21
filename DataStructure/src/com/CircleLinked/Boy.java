package com.CircleLinked;

class Josephus{
    public static void main(String[] args) {
        CircleLinked circleLinked = new CircleLinked();
        circleLinked.add(5);
        circleLinked.countNum(1, 2, 5);
    }
}

class CircleLinked{
    public Boy first = new Boy(1);

    public void add(int num){
        if(num < 1){
            System.out.println("num的值不正确");
            return;
        }
        Boy boycur = first;
        for (int i = 2; i <= num; i++) {
            boycur.next = new Boy(i);
            boycur = boycur.next;
        }
        boycur.next = first;
    }

    public void show(){
        Boy boyCur = first;
        do
        {
            System.out.println(boyCur.no);
            boyCur = boyCur.next;
        }while (boyCur != first);
    }


    public void countNum(int k, int m, int numbs){
         Boy boy = first;
         while (boy.next != first){
             boy = boy.next;
         }

        while (first.no != k){
            first = first.next;
            boy = boy.next;
        }
        while (true){
            for (int i = 0; i < m - 1; i++) {
                first = first.next;
                boy = boy.next;
            }
            System.out.println(first.no);
            first = first.next;
            boy.next = first;
            if(first == boy){
                break;
            }
        }
        System.out.println("最后剩下" + first.no);
    }


}

public class Boy {
    public int no;
    public Boy next;

    public Boy(int no) {
        this.no = no;
    }
}
