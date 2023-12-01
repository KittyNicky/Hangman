package com.kittynicky.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Words {
    private static final String WORDS_PATH = "src/main/resources/russian_nouns.txt";
    private static final int MIN_WORD_LENGTH = 6;
    private List<String> listWords;
    private Set<Character> enteredCharacters;
    private String hiddenWord;


    public Words() {
        this.listWords = new ArrayList<>();
        this.enteredCharacters = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(WORDS_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() < MIN_WORD_LENGTH) {
                    continue;
                }
                this.listWords.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        return listWords.get(random.nextInt(listWords.size()));
    }

    public String getEncryptedWord(String word) {
        StringBuilder encryptedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (!enteredCharacters.contains(letter)) {
                encryptedWord.append('*');
            } else {
                encryptedWord.append(letter);
            }
        }
        return encryptedWord.toString();
    }

    public boolean containsChar(String word, char c) {
        return word.indexOf(c) != -1;
    }


    public void setHiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public void addEnteredLetter(char c) {
        enteredCharacters.add(c);
    }

    public Set<Character> getEnteredCharacters() {
        return enteredCharacters;
    }
}
