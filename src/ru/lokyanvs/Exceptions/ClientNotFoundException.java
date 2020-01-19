package ru.lokyanvs.Exceptions;

public class ClientNotFoundException extends Exception {

    public ClientNotFoundException(){
        super("Клиент не найден");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
