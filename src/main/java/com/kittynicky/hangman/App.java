package com.kittynicky.hangman;

import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Начать новую игру или выйти? [Y/N]");
            String line = scanner.nextLine();

            if (!InputValidator.validate(line)) {
                System.out.println("Введено более 1 символа. Попробуйте еще раз.\n");
                continue;
            }

            char c = line.toUpperCase(Locale.ROOT).charAt(0);
            if (c == 'Y') {
                System.out.println("Игра начинается...\n");
                Game game = new Game();
                game.run();
            } else if (c == 'N') {
                System.out.println("Выход из игры...\n");
                break;
            } else {
                System.out.println("Неизвестная командна. Попробуйте еще раз.\n");
            }
        } while (true);
    }
}