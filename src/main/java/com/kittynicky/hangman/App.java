package com.kittynicky.hangman;

import java.util.Locale;
import java.util.Scanner;

public class App {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Начать новую игру или выйти? [Y/N]");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Введено более 1 символа. Попробуйте еще раз.");
                continue;
            }

            char c = input.toUpperCase(Locale.ROOT).charAt(0);
            if (c == 'Y') {
                System.out.println("Игра началась.\n");
                Game game = new Game();
                game.run();
            } else if (c == 'N') {
                System.out.println("Игра завершена.");
                break;
            } else {
                System.out.println("Неизвестная командна. Попробуйте еще раз.\n");
            }
        } while (true);
    }
}
