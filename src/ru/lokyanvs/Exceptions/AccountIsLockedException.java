package ru.lokyanvs.Exceptions;

public class AccountIsLockedException extends Exception{

    public AccountIsLockedException (){
        super("Некорректный пин");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
