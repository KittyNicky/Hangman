package com.kittynicky.hangman;

import java.util.HashSet;
import java.util.Set;

public class HiddenWord {
    private String hiddenWord;
    private final Set<Character> enteredLetters = new HashSet<>();

    public HiddenWord() {
    }

    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public Set<Character> getEnteredLetters() {
        return enteredLetters;
    }

    public boolean contains(char c) {
        return hiddenWord.indexOf(c) != -1;
    }

    public void addEnteredLetter(char c) {
        enteredLetters.add(c);
    }

    public String getEncryptedHiddenWord() {
        StringBuilder encryptedWord = new StringBuilder();
        for (int i = 0; i < hiddenWord.length(); i++) {
            char letter = hiddenWord.charAt(i);
            if (!enteredLetters.contains(letter)) {
                encryptedWord.append('*');
            } else {
                encryptedWord.append(letter);
            }
        }
        return encryptedWord.toString();
    }

    public boolean isWordDecrypted() {
        return getEncryptedHiddenWord().indexOf('*') == -1;
    }
}
