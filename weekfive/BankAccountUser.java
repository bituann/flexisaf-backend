package com.flexisaf.weekfive;

import com.flexisaf.weekfive.BankAccountUserException.*;

import java.util.Scanner;

public class BankAccountUser {
    private String name;
    private int acctNum;
    private String pin;
    private double balance;

    public BankAccountUser (String name, int acctNum, String pin) {
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

    public void withdraw (double amount, String pin) throws InvalidAmountException, InsufficientFundsException, InvalidPinException {
        if (!pin.equals(this.pin)) {
            throw new InvalidPinException("The pin provided is incorrect");
        }

        if (amount <= 0) {
            throw new InvalidAmountException("The amount entered is invalid");
        }

        if (amount > this.balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        this.balance -= amount;
    }

    public double getBalance () {
        return this.balance;
    }

    public void changePin (String pin) {
        this.pin = pin;
    }
}
