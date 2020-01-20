package ru.lokyanvs.Exceptions;

public class AccountIsLockedException extends Exception{

    public AccountIsLockedException (){
        super("Вы некорректный пин-код 3 раза, доступ заблокирован");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
