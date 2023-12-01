package com.kittynicky.hangman;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    private static final int MIN_ERRORS = 0;
    private static final int MAX_ERRORS = 6;
    private int countErrors;
    private Hangman hangman;
    private Words words;

    public Game() {
        this.countErrors = MIN_ERRORS;
        this.hangman = new Hangman();
        this.words = new Words();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String hiddenWord = words.getRandomWord();
        String encryptedWord = words.getEncryptedWord(hiddenWord);
        words.setHiddenWord(hiddenWord);

        hangman.printHangman(getCountErrors());
        System.out.println("encryptedWord=" + encryptedWord + ",countErrors=" + getCountErrors());

        while (true) {
            System.out.println("Введите букву [а - я]:");
            String input = scanner.nextLine();

            if (input.length() != 1) {
                System.out.println("Введено более 1 символа. Попробуйте еще раз.");
                continue;
            }

            char letter = input.toLowerCase(Locale.ROOT).charAt(0);

            if (words.getEnteredCharacters().contains(letter)) {
                System.out.println("Буква '" + letter + "' уже была введена ранее. Попробуйте еще раз.");
                continue;
            }

            words.addEnteredLetter(letter);
            encryptedWord = words.getEncryptedWord(hiddenWord);

            if (!words.containsChar(encryptedWord, letter)) {
                setCountErrors(getCountErrors() + 1);
                hangman.printHangman(getCountErrors());
                if (this.getCountErrors() == MAX_ERRORS) {
                    hangman.printHangman(getCountErrors());
                    System.out.println("Вы проиграли...");
                    break;
                }
            }

            if (!words.containsChar(encryptedWord, '*')) {
                System.out.println("Поздравляем! Вы отгадали слово '" + encryptedWord + "'!");
                break;
            }

            hangman.printHangman(getCountErrors());
            System.out.println("encrypted word=" + encryptedWord + "\ncount errors=" + getCountErrors());
        }
    }

    public int getCountErrors() {
        return countErrors;
    }

    public void setCountErrors(int countErrors) {
        this.countErrors = countErrors;
    }
}
