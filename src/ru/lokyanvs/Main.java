package ru.lokyanvs;

import ru.lokyanvs.Terminal.TerminalLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*do {
            System.out.println("Введите сайт");
        } while (readContent(scanner.nextLine()) == -1);
        */

        new TerminalLogic().runTerminal();

    }

    static int readContent(String s) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(( (new URL(s)).openConnection()).getInputStream()))) {
            String content;
            while ((content = br.readLine()) != null)
                System.out.println(content);
        } catch (MalformedURLException e) {
            System.out.println("Некорректрный URL, повторите ввод");
            return -1;
        } catch (IOException e) {
            System.out.println("Не удается получить доступ к сайту");
            return -1;
        }
        return 1;
    }
}
