package com.autobots.java.lambda.bankApplication;

import java.util.HashSet;
import java.util.Set;

public class MBank extends BankBase {
private static Set<MBank> mBankRecords = new HashSet<>();
    private double balance = 200;

    public MBank(long accountNumber, long routingNumber) throws Exception{
        super(accountNumber, routingNumber,"MBank");
        addToAllBankRecords(this);
mBankRecords.add(this);


    }
    public static Set<MBank> getMBankRecords(){
        return mBankRecords;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {

        if (amount < 0 || amount >=200000){
            throw  new IllegalArgumentException("invalid amount can not  be amount");
        }
        balance += amount;
    }

    @Override
    public void withDraw(double amount) {

        if (amount<0 || amount >= 150000){
            throw new IllegalArgumentException("invalid amount can not be withDrew");
        }else {
            if (amount > balance){
                throw  new IllegalArgumentException("insufficient funds");
            }else {
                balance -= amount;
            }
        }

    }

}