package ru.lokyanvs.Interfaces;

import ru.lokyanvs.Client;

public interface Terminal {

    //проверка счета клиента
    public void checkAccount(int balance);

    //внесение наличных
    public int deposit();

    //снятие наличных
    public int withdraw();

    public String askName();

    public int askPin();

    public void showExceptionInfo(String info);

    public void showExceptionInfo(Exception e);

    public int showMenu();
}
