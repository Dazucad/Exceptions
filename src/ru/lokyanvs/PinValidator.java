package ru.lokyanvs;

import ru.lokyanvs.Exceptions.AccountIsLockedException;
import ru.lokyanvs.Exceptions.IncorrectPin;

public class PinValidator {

    private Client currentClient;
    private int tries;

    public boolean checkPin(Client client, int pin) throws AccountIsLockedException, IncorrectPin {
        if (currentClient != client) {
            currentClient = client;
            tries = 0;
        }
        if (client.isBlocked()) throw new AccountIsLockedException();
        if (client.getPin() != pin) {
            if (++tries >= 3) {
                client.setBlocked();
                tries = 0;
            }
            throw new IncorrectPin();
        } else {
            tries = 0;
            return true;
        }
    }
}
