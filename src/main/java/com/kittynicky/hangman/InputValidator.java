package com.kittynicky.hangman;

public class InputValidator {
    public static boolean validate(Character c) {
        if (c < 'а' || c > 'я') {
            System.out.println("Неизвестный символ. Попробуйте снова.\n");
            return false;
        }
        return true;
    }

    public static boolean validate(String s) {
        if (s.length() != 1) {
            System.out.println("Введено более 1 символа. Попробуйте снова.\n");
            return false;
        }
        return true;
    }
}
