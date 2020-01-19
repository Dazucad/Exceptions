package ru.lokyanvs;

import ru.lokyanvs.Exceptions.ClientNotFoundException;
import ru.lokyanvs.Exceptions.IncorrectAmountException;
import ru.lokyanvs.Exceptions.InsufficientFundsException;

import java.util.*;

public class TerminalServer {
    Map<String, Client> clientsList = new HashMap<>();

   public TerminalServer() {
        //создание списка клиентов
        clientsList.put("Иванов Иван Иванович", new Client("Иванов Иван Иванович", 1000, 1234));
        clientsList.put("Сергеев Сергей Сергеевич", new Client("Сергеев Сергей Сергеевич", 1000, 4321));
        clientsList.put("Петров Петр Петрович", new Client("Петров Петр Петрович", 1000, 5555));
    }

    public Client getClient(String name) throws ClientNotFoundException {
        Client client = clientsList.get(name);
        if (client == null) throw new ClientNotFoundException();
        return client;
    }

    public int withdrawMoney(Client client, int sum) throws IncorrectAmountException, InsufficientFundsException {
        if (sum % 100 != 0) throw new IncorrectAmountException();
        if (client.getDeposit() < sum) throw new InsufficientFundsException();
        client.setDeposit(client.getDeposit() - sum);
        return sum;
    }

    public int depositMoney(Client client, int sum) {
        client.setDeposit(client.getDeposit() + sum);
        return sum;

    }

    public int getDeposit(Client client){
        return client.getDeposit();
    }

}
