package com.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents a lesson in the language learning application.
 */
public class Lesson {

    private ArrayList<Question> questions;
    private Language language;
    private String topic;
    private int numQuestionsCorrect;
    private static final int diff = 1;

    // Constructor for the lesson class
    public Lesson(String topic, Language language) {
        this.topic = topic;
        this.questions = new ArrayList<>();
        this.language = language;
        this.numQuestionsCorrect = 0;

        WordList wordList = WordList.getInstance();

        // Add a Multiple Choice question
        Word randomWord = wordList.getRandomWord(language);
        if (randomWord != null) {
            questions.add(new MultipleChoice(diff, randomWord, language));
        }

        // Add a Vocab Matching question
        Word randomWordForVocab = wordList.getRandomWord(language);
        if (randomWordForVocab != null) {
            questions.add(new VocabularyMatching(randomWordForVocab, language, diff));
        }

        // Add a True/False question
        Word randomWordForTrueFalse = wordList.getRandomWord(language);
        if (randomWordForTrueFalse != null) {
            boolean isCorrect = new Random().nextBoolean();
            questions.add(new TrueFalse(randomWordForTrueFalse, isCorrect, diff));
        }
    }

    // Function to play the lesson
    public int playLesson() {
        System.out.println("Starting lesson: " + topic);
        Scanner scanner = new Scanner(System.in); // Scanner object for user input

        for (Question question : questions) {
            boolean isCorrect = question.askQuestion(scanner); // Updated to pass Scanner
            if (isCorrect) {
                numQuestionsCorrect++;
            }
        }

        // Calculate and print the score
        int score = (numQuestionsCorrect * 100) / questions.size();
        System.out.println("Lesson completed. Score: " + score + "%");

        if (score >= 80) {
            System.out.println("You passed! Proceeding to the next module.");
        } else {
            System.out.println("You did not pass. Please try this lesson again.");
        }

        return score;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public Question getCurrentQuestion(int index) {
        if (index >= 0 && index < questions.size()) {
            return questions.get(index);
        }
        return null; // Or throw an exception if index is out of bounds
    }
}
