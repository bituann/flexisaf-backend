package com.flexisaf.weekfive;
import java.lang.Exception;

public class BankAccountUserException {
    public static class InvalidAmountException extends Exception{

    }

    public static class InsufficientFundsException extends Exception {

    }
}