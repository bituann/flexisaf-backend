package com.flexisaf.weekfive;

import java.lang.Exception;

public class BankAccountUserException {
    public static class InvalidAmountException extends Exception{
        public InvalidAmountException () {}

        public InvalidAmountException (String message) {
            super(message);
        }
    }

    public static class InsufficientFundsException extends Exception {
        public InsufficientFundsException () {}

        public InsufficientFundsException (String message) {
            super(message);
        }
    }

    public static class InvalidPinException extends Exception {
        public InvalidPinException () {}

        public InvalidPinException (String message) {
            super(message);
        }
    }
}