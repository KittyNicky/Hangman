package com.kittynicky.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Words {
    private static final String WORDS_PATH = "src/main/resources/russian_nouns.txt";
    private static final int MIN_WORD_LENGTH = 5;
    private final List<String> listWords;

    public Words() {
        this.listWords = new ArrayList<>();
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
}
