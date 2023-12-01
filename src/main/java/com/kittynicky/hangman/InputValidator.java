package com.kittynicky.hangman;

public class InputValidator {
    public static boolean validate(Character c) {
        return c >= 'а' && c <= 'я';
    }

    public static boolean validate(String s) {
        return s.length() == 1;
    }
}
