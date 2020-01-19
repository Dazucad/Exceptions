package ru.lokyanvs.Exceptions;

public class NotEnoughMoneyException extends Exception {

    public NotEnoughMoneyException(){
        super("Недостаточно средств на счете");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
