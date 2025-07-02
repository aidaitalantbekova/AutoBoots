package com.autobots.java.lambda.bankApp;

public class DepositAccount extends BankAccount{

    public DepositAccount(Client owner, Currency currency) {
        super(owner, currency);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("DEPOSIT",amount);
    }


    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance){
            balance -= amount;
            addTransaction("WITHDRAW",amount);
            return true;
        }
        return false;
    }
}
