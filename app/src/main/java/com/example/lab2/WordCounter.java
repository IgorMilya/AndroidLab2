package com.example.lab2;

public class WordCounter {
    public int countWords(String text) {
        String[] words = text.trim().split(" ");

        int wordNumber = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                wordNumber++;
            }
        }
        return wordNumber;
    }
    public int countCharacters(String text) {
        return text.length();
    }
}

