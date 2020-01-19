package ru.lokyanvs.Exceptions;

public class IncorrectPin extends Exception {
    public IncorrectPin(){
        super("Некорректный пин-код");
    }
}
