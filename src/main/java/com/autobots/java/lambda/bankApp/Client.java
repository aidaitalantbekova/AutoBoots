package com.autobots.java.lambda.bankApp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {

    private final String fullName;
    private final String clientID;
    private final String pin;
    private final List<BankAccount> accounts = new ArrayList<>();

    public Client( String fullName ,String pin) {
        this.pin = pin;
        this.fullName = fullName;
        this.clientID = String.valueOf(UUID.randomUUID());
    }

    public boolean authenticate (String inputPin){
        return this.pin.equals(inputPin);
    }
   public void addAccount (BankAccount account){
        accounts.add(account);
    }

    public String getFullName() {
        return fullName;
    }

    public String getClientID() {
        return clientID;
    }


    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
