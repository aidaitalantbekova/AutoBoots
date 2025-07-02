package com.autobots.java.lambda.bankApplication;

public interface Bank {

    double getBalance();
    void deposit(double amount);
    void withDraw(double amount);

    static void transferFunds(Bank sender, Bank recipient, double transferAmount) {
        sender.withDraw(transferAmount);
        recipient.deposit(transferAmount);
    }
}

