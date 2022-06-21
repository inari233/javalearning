package com.exercise.exercise04;

import com.OOP.modifier.B;

public class SavingsAccount extends BankAccount {
    private int count = 3;
    private double MonthlyInterest = 0.3;

    public SavingsAccount(double balance) {
        super(balance);
    }

    public void earnMonthlyInterest(){
        setBalance(getBalance() * (1 + MonthlyInterest ));
        count = 3;
    }

    @Override
    public void deposit(double amount) {
        if(count > 0){
            super.deposit(amount);
            count--;
        }else {
            super.deposit(amount - 1);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (count > 0){
            super.withdraw(amount);
            count--;
        }else {
            super.withdraw(amount + 1);
        }
    }
}
