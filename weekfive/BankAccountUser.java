package com.flexisaf.weekfive;
import com.flexisaf.weekfive.BankAccountUserException.*;

public class BankAccountUser {
    private String name;
    private int acctNum;
    private int pin;
    private double balance;

    public BankAccountUser (String name, int acctNum, int pin) {
        this.name = name;
        this.acctNum = acctNum;
        this.pin = pin;
        this.balance = 0;
    }

    public void deposit (double amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException();
        }

        this.balance += amount;
    }

    public void withdraw (double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount < 100) {
            throw new InvalidAmountException();
        }

        if (amount < balance) {
            throw new InsufficientFundsException();
        }


    }
}
