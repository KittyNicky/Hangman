package com.kittynicky.hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Words {
    private static final String WORDS_PATH = "src/main/resources/russian_nouns.txt";
    private static final int MIN_WORD_LENGTH = 6;
    private final List<String> listWords = new ArrayList<>();

    public Words() {
        try (BufferedReader reader = new BufferedReader(new FileReader(WORDS_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.length() > MIN_WORD_LENGTH) {
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
