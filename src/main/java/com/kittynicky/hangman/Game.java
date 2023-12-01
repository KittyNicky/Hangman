package com.kittynicky.hangman;

import java.util.Locale;
import java.util.Scanner;

public class Game {
    private static final int MIN_ERRORS = 0;
    private static final int MAX_ERRORS = 6;
    private int countErrors;
    private final Hangman hangman;
    private final Words words;
    private final HiddenWord hiddenWord;

    public Game() {
        this.countErrors = MIN_ERRORS;
        this.hangman = new Hangman();
        this.words = new Words();
        this.hiddenWord = new HiddenWord(words.getRandomWord());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        hiddenWord.setHiddenWord(words.getRandomWord());
        printGameInfo();

        while (true) {
            System.out.println("Введите букву [а - я]:");
            String line = scanner.nextLine();

            if (!validate(line)) {
                System.out.println("Введено более 1 символа. Попробуйте еще раз.");
                continue;
            }

            char letter = line.charAt(0);
            if (!validate(letter)) {
                System.out.println("Неизвестный символ. Попробуйте снова.");
                continue;
            }

            if (hiddenWord.getEnteredLetters().contains(letter)) {
                System.out.println("Буква '" + letter + "' уже была введена ранее. Попробуйте еще раз.");
                continue;
            }

            hiddenWord.addEnteredLetter(letter);

            if (!hiddenWord.contains(letter)) {
                setCountErrors(getCountErrors() + 1);
                if (this.getCountErrors() == MAX_ERRORS) {
                    printGameInfo();
                    System.out.println("Вы проиграли...");
                    break;
                }
            }

            if (hiddenWord.isWordDecrypted()) {
                printGameInfo();
                System.out.println("Поздравляем! Вы отгадали слово!");
                break;
            }

            printGameInfo();
        }
    }

    public int getCountErrors() {
        return countErrors;
    }

    public void setCountErrors(int countErrors) {
        this.countErrors = countErrors;
    }

    private void printGameInfo() {
        hangman.printHangman(getCountErrors());
        System.out.println("encrypted word=" + hiddenWord.getEncryptedHiddenWord() + "\ncount errors=" + getCountErrors());
    }

    private boolean validate(Character c) {
        return c >= 'а' && c <= 'я';
    }

    private boolean validate(String s) {
        return s.length() == 1;
    }
}
