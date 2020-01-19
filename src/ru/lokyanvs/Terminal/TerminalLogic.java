package ru.lokyanvs.Terminal;

import ru.lokyanvs.Client;
import ru.lokyanvs.Exceptions.*;
import ru.lokyanvs.Interfaces.MenuConstants;
import ru.lokyanvs.PinValidator;
import ru.lokyanvs.TerminalServer;

public class TerminalLogic implements MenuConstants {

    private TerminalUI terminalUI;

    public TerminalLogic() {
        terminalUI=new TerminalUI();
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
                        } catch (AccountIsLockedException|IncorrectPin e) {
                            terminalUI.showExceptionInfo(e);
                        }
                        break;
                    }
                    case WITHDRAW: {
                        if (pinChecked) {
                            try {
                                terminalServer.withdrawMoney(client, terminalUI.withdraw());
                            } catch (InsufficientFundsException|IncorrectAmountException e) {
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
            } while (command!=END);
        }
    }
}
