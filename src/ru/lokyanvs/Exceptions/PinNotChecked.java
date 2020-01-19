package ru.lokyanvs.Exceptions;

public class PinNotChecked extends Exception{
    public PinNotChecked(){
        super("Сначала введите пин-код");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
