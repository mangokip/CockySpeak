package com.model;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VocabularyMatchingTest {
    private VocabularyMatching vocabularyMatching;
    private Word randomWord;
    private Language language;
    private WordList wordList = WordList.getInstance("/words.json");

    @BeforeEach
    void setUp() {
        language = new Language("Spanish");
        randomWord = wordList.getRandomWord(language);
        vocabularyMatching = new VocabularyMatching(randomWord, language, 1);
    }

    @Test
    void testPopulateWordPairs() {
        Map<String, String> wordPairs = vocabularyMatching.getWordPairs();
        assertEquals(3, wordPairs.size());
        assertTrue(wordPairs.containsKey(randomWord.getText().toLowerCase()));
        assertEquals(randomWord.getForeign().toLowerCase(), wordPairs.get(randomWord.getText().toLowerCase()));
    }

    @Test
    void testValidateAnswerCorrect() {
        Map<String, String> correctUserPairs = new HashMap<>(vocabularyMatching.getWordPairs());
        vocabularyMatching.getUserPairs().putAll(correctUserPairs);
        assertTrue(vocabularyMatching.validateAnswer(""));
    }

    @Test
    void testValidateAnswerIncorrect() {
        Map<String, String> incorrectUserPairs = new HashMap<>(vocabularyMatching.getWordPairs());
        incorrectUserPairs.replace(incorrectUserPairs.keySet().iterator().next(), "wrongAnswer");
        vocabularyMatching.getUserPairs().putAll(incorrectUserPairs);
        assertFalse(vocabularyMatching.validateAnswer(""));
    }

    @Test
    void testValidateEmptyAnswer() {
        Map<String, String> incorrectUserPairs = new HashMap<>(vocabularyMatching.getWordPairs());
        incorrectUserPairs.replace(incorrectUserPairs.keySet().iterator().next(), " ");
        vocabularyMatching.getUserPairs().putAll(incorrectUserPairs);
        assertFalse(vocabularyMatching.validateAnswer(""));

    }

    
    
}
