package ru.lokyanvs.Terminal;

import ru.lokyanvs.Client;
import ru.lokyanvs.Exceptions.*;
import ru.lokyanvs.PinValidator;
import ru.lokyanvs.TerminalServer;

public class TerminalLogic {

    private TerminalUI terminalUI;

    private static final int PIN = 1;
    private static final int WITHDRAW = 2;
    private static final int DEPOSIT = 3;
    private static final int BALANCE = 4;
    private static final int END = 5;

    public TerminalLogic() {
        terminalUI = new TerminalUI();
        runTerminal();
    }

    private final TerminalServer terminalServer = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();

    public void runTerminal() {
        while (true) {
            boolean pinChecked;
            pinChecked = false;
            Client client;
            try {
                client = terminalServer.getClient(terminalUI.askName());
            } catch (ClientNotFoundException e) {
                terminalUI.showExceptionInfo(e);
                continue;
            }
            int command;
            do {
                command = terminalUI.showMenu();
                switch (command) {
                    case PIN: {
                        try {
                            pinChecked = pinValidator.checkPin(client, terminalUI.askPin());
                        } catch (AccountIsLockedException | IncorrectPin e) {
                            terminalUI.showExceptionInfo(e);
                        }
                        break;
                    }
                    case WITHDRAW: {
                        if (pinChecked) {
                            try {
                                terminalServer.withdrawMoney(client, terminalUI.withdraw());
                            } catch (InsufficientFundsException | IncorrectAmountException e) {
                                terminalUI.showExceptionInfo(e);
                            }
                        } else terminalUI.showExceptionInfo(new PinNotChecked());
                        break;
                    }
                    case DEPOSIT: {
                        if (pinChecked) {
                            terminalServer.depositMoney(client, terminalUI.deposit());
                        } else terminalUI.showExceptionInfo(new PinNotChecked());
                    }
                    case BALANCE: {
                        if (pinChecked) {
                            terminalUI.checkAccount(terminalServer.getDeposit(client));
                        } else terminalUI.showExceptionInfo(new PinNotChecked());
                    }
                }
            } while (command != END);
        }
    }
}
