package com.kittynicky.hangman;

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
        printInfo();

        while (true) {
            System.out.println("Введите букву [а - я]:");
            String line = scanner.nextLine();

            if (!InputValidator.validate(line)) {
                continue;
            }

            char letter = line.charAt(0);
            if (!InputValidator.validate(letter)) {
                continue;
            }

            if (hiddenWord.getEnteredLetters().contains(letter)) {
                System.out.println("Буква '" + letter + "' уже была введена ранее. Попробуйте снова.\n");
                continue;
            }

            hiddenWord.addEnteredLetter(letter);

            if (!hiddenWord.contains(letter)) {
                setCountErrors(getCountErrors() + 1);
                if (this.getCountErrors() == MAX_ERRORS) {
                    printInfo();
                    System.out.println("Вы проиграли.\n");
                    break;
                }
            }

            if (hiddenWord.isHiddenWordDecrypted()) {
                printInfo();
                System.out.println("Поздравляем! Вы выиграли!\n");
                break;
            }

            printInfo();
        }
    }

    public int getCountErrors() {
        return countErrors;
    }

    public void setCountErrors(int countErrors) {
        this.countErrors = countErrors;
    }

    private void printInfo() {
        hangman.printHangman(getCountErrors());
        System.out.println("encrypted word: " + hiddenWord.getEncryptedHiddenWord()
                + "\ncount errors: " + getCountErrors()
                + "\n");
    }
}