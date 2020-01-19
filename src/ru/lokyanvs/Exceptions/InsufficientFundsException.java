package ru.lokyanvs.Exceptions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(){
        super("Недостаточно средств");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
