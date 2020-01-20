package ru.lokyanvs.Terminal;

import ru.lokyanvs.Interfaces.Terminal;

import java.util.Scanner;

public class TerminalUI implements Terminal {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void checkAccount(int balance) {
        System.out.println("Остаток на счете:" + balance);
    }

    @Override
    public int deposit() {
        System.out.println("Введите сумму");
        int sum = 0;
        while (sum == 0) {
            try {
                sum = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
        return sum;
    }

    @Override
    public int withdraw() {
        System.out.println("Введите сумму для снятия:");
        int sum = -1;
        while (sum < 0) {
            try {
                sum = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
        return sum;
    }

    @Override
    public String askName() {
        System.out.println("Введите ФИО");
        return scanner.nextLine();
    }

    @Override
    public int askPin() {
        System.out.println("Введите пин-код:");
        int pin = 0;
        while (pin == 0) {
            try {
                pin = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
        return pin;
    }

    @Override
    public void showExceptionInfo(String info) {
        System.out.println(info);
    }

    @Override
    public void showExceptionInfo(Exception e) {
        System.out.println(e.getMessage());
    }

    @Override
    public int showMenu() {
        System.out.println("Введите номер операции:\n1. Ввести пин-код\n2. Снять деньги\n3. Внести деньги\n4. Узнать баланс\n5. Завершить обслуживание");
        int menuItem = 0;
        while (menuItem == 0) {
            try {
                menuItem = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод");
            }
        }
        return menuItem;
    }
}
