package com.OOP.encapsulation01;

public class Account {
    public static void main(String[] args) {
        myAccount jack = new myAccount("jack", 20000, 12311);
        int my_balance = jack.getBalance();
        System.out.println(my_balance);
        jack.setPassword(123);

    }
}

class myAccount {
    private String name;
    private int balance;
    private int password;

    public myAccount(String name, int balance, int password) {
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 5) {
            this.name = name;
        } else {
            System.out.println("名字过长");
            this.name = "jack";
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            System.out.println("余额必须在20以上");
            this.balance = 5000;
        }
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        if (password > 100000) {
            this.password = password;
        } else {
            System.out.println("密码必须大于六位数");
            this.password = 123456;
        }
    }
}
