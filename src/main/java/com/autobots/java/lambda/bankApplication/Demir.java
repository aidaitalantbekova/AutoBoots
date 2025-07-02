package com.autobots.java.lambda.bankApplication;

import java.util.HashSet;
import java.util.Set;

public class Demir extends BankBase{

private static Set<Demir> demirRecords = new HashSet<>();
    private double balance = 500;

    public Demir(long accountNumber, long routingNumber) throws Exception{
        super(accountNumber, routingNumber,"Demir");
        addToAllBankRecords(this);
        demirRecords.add(this);



    }
    public static Set<Demir> getDemirRecords(){
        return demirRecords;

    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {

        if (amount < 0 || amount >=500000){
            throw  new IllegalArgumentException("invalid amount can not  be amount");
        }
        balance += amount;
    }

    @Override
    public void withDraw(double amount) {

        if (amount < 0 || amount >= 450000){
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