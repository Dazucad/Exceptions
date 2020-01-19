package ru.lokyanvs;

public class Client {
    private String name;
    private int deposit;
    private int pin;
    private boolean blocked;
    private long blockTime;

    String getName() {
        return name;
    }

    int getDeposit() {
        return deposit;
    }

    Client setDeposit(int deposit) {
        this.deposit = deposit;
        return this;
    }

    Client(String name, int deposit, int pin) {
        this.name = name;
        this.deposit = deposit;
        this.pin = pin;
        blocked = false;
        blockTime = 0;
    }

    int getPin() {
        return pin;
    }

    void setBlocked() {
        blocked = true;
        blockTime = System.currentTimeMillis();
    }

    boolean isBlocked() {
        if (System.currentTimeMillis() - blockTime > 20000) {
            blockTime = 0;
            blocked = false;
        }
        return blocked;
    }

}
