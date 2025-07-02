package com.autobots.java.lambda.bankApplication;

import java.util.HashSet;
import java.util.Set;

public class Optima extends BankBase{

    private static Set<Optima> optimaRecords = new HashSet<>();
    private double balance = 0;

    public Optima(long accountNumber, long routingNumber) throws Exception{
        super(accountNumber, routingNumber,"Optima");
        addToAllBankRecords(this);
optimaRecords.add(this);


    }
    public static Set<Optima> getOptimaRecords(){
        return optimaRecords;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {

        if (amount < 0 || amount >=300000){
            throw  new IllegalArgumentException("invalid amount can not  be amount");
        }
        balance += amount;
    }

    @Override
    public void withDraw(double amount) {

        if (amount<0 || amount >= 250000){
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