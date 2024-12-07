package com.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Class for a multiple choice question.
 * @param answerOptions - List of Word objects that represent the possible answers
 * @param correctAnswer - Word object that represents the correct answer
 */
public class MultipleChoice extends Question {

    private List<Word> answerOptions;
    private Word correctAnswer;

    /*
     * Constructor for a multiple choice question.
     * @param difficulty - The difficulty level of the multiple choice question
     * @param correctAnswer - The correct answer for the multiple choice question
     * @param language - The language to be used for the multiple choice question
     */
    public MultipleChoice(int difficulty, Word correctAnswer, Language language) {
        super("Select the foreign word that matches this English word: " + correctAnswer.getText(), difficulty);
        this.correctAnswer = correctAnswer;
        this.answerOptions = new ArrayList<>();
        populateAnswerOptions(language);
    }

    /*
     * Populates the answer options list with random words from the passed language, then shuffles the list.
     * @param language - The language to be used for the multiple choice question
     */
    private void populateAnswerOptions(Language language) {
        WordList wordList = WordList.getInstance();
        List<Word> genreWords = wordList.getWordsByGenre(language, correctAnswer.getGenre());

        answerOptions.add(correctAnswer);

        Random rand = new Random();
        while (answerOptions.size() < 4) {
            Word randomWord = genreWords.get(rand.nextInt(genreWords.size()));
            if (!answerOptions.contains(randomWord)) {
                answerOptions.add(randomWord);
            }
        }

        Collections.shuffle(answerOptions);
    }

    /*
     * Prints the question and the answer options and asks the user to select an answer.
     * This method is used in the lesson class to ask each question.
     */
    @Override
    public boolean askQuestion(Scanner scanner) {
        pronouncePrompt();  // Pronounce the question before displaying

        System.out.println(getPrompt());

        for (int i = 0; i < answerOptions.size(); ++i) {
            System.out.println((i + 1) + ". " + answerOptions.get(i).getForeign());
        }

        System.out.print("Enter your answer (1-4): ");
        String userAnswer = scanner.nextLine().trim();

        boolean result = validateAnswer(userAnswer);
        if (result) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer is: " + correctAnswer.getForeign());
        }
        return result;
    }

    // Function to validate the user's answer based on the answer options list and the correct answer.
    // Returns true if the user's answer is correct and false if it is not.
    @Override
    public boolean validateAnswer(String userAnswer) {
        try {
            int answerIndex = Integer.parseInt(userAnswer) - 1;
            return answerOptions.get(answerIndex).equals(correctAnswer);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number between 1 and 4.");
            return false;
        }
    }

    public List<String> getAnswerOptions() {
        // Convert each Word object in the options list to its foreign string representation
        List<String> foreignOptions = new ArrayList<>();
        for (Word word : answerOptions) {
            foreignOptions.add(word.getForeign());
        }
        return foreignOptions;
    }
    

    // Getter for the correct answer
    public Word getCorrectAnswer() {
        return correctAnswer;
    }

    
}
