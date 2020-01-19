package ru.lokyanvs.Exceptions;

public class IncorrectAmountException extends IllegalArgumentException {
    public IncorrectAmountException() {
        super("Сумма должна быть кратна 100");
    }

    @Override
    public String toString() {
        return super.getMessage();
    }
}
