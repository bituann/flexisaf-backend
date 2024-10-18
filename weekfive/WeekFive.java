package com.flexisaf.weekfive;

import com.flexisaf.weekfive.BankAccountUserException.*;

public class WeekFive {
    public static void main (String[] args) {
        BankAccountUser userOne = new BankAccountUser("Tobi", 12345, "1111");

        try {
            userOne.deposit(10000);
            userOne.withdraw(10, "1111");
        } catch (InvalidAmountException | InsufficientFundsException | InvalidPinException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("The End of Try Block");
        }

        System.out.println(userOne.getBalance());
    }
}


