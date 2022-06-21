package com.exercise.exercise04;

public class Test {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(20000);
        bankAccount.deposit(500);
        bankAccount.withdraw(5000);
        System.out.println(bankAccount.getBalance());

        CheckingAccount checkingAccount = new CheckingAccount(20000);
//        checkingAccount.deposit(500);
        checkingAccount.withdraw(5000);
        System.out.println(checkingAccount.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(20000);
        savingsAccount.deposit(500);
        savingsAccount.deposit(500);
        savingsAccount.deposit(500);
        System.out.println(savingsAccount.getBalance());
        savingsAccount.earnMonthlyInterest();
        System.out.println(savingsAccount.getBalance());


    }
}
