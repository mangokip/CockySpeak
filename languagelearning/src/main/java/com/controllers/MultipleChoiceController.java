package com.controllers;

import com.model.WordList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.language.App;
import com.model.Word;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MultipleChoiceController {

    WordList wordList = WordList.getInstance();
    Word correctAnswer = wordList.getRandomWord("Spanish");

    
    

    @FXML
    private Label questionLabel;
    
    @FXML
    private Label feedbackLabel;

    @FXML
    private Button optionA;

    @FXML
    private Button optionB;

    @FXML
    private Button optionC;

    @FXML
    private Button optionD;

    @FXML
    private Button nextButton;

    @FXML
    private void handleOptionA() {
        checkAnswer(optionA);
    }

    @FXML
    private void handleOptionB() {
        checkAnswer(optionB);
    }

    @FXML
    private void handleOptionC() {
        checkAnswer(optionC);
    }

    @FXML
    private void handleOptionD() {
        checkAnswer(optionD);
    }

    /**
     * This method checks the selected answer against the correct one and provides feedback.
     */
    private void checkAnswer(Button selectedOption) {
        if (selectedOption.getText().equals(correctAnswer.getForeign())) {
            feedbackLabel.setText("Correct! Great job!");
            feedbackLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        } else {
            feedbackLabel.setText("Incorrect! The correct answer is: " + correctAnswer.getForeign());
            feedbackLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        feedbackLabel.setVisible(true);
        nextButton.setVisible(true);
        optionA.setDisable(true);
        optionB.setDisable(true);
        optionC.setDisable(true);
        optionD.setDisable(true);
    }

    @FXML
    private void nextButtonAction() throws IOException {
        App.setRoot("vocabMatching");
    }

    // Placeholder methods for the bottom bar
    @FXML
    private void handleHome() {
        System.out.println("Home clicked");
    }

    @FXML
    private void handleRanking() {
        System.out.println("Ranking clicked");
    }

    @FXML
    private void handleFlashcards() {
        System.out.println("Flashcards clicked");
    }

    @FXML
    private void handleProfile() {
        System.out.println("Profile clicked");
    }

    @FXML
    private void populateOptions() {
        // Create a list to hold all the options
        List<String> options = new ArrayList<>();
        
        // Add the correct answer
        String correctTranslation = correctAnswer.getForeign();
        options.add(correctTranslation);

        // Add three random unique incorrect answers
        while (options.size() < 4) {
            Word randomWord = wordList.getRandomWord("Spanish");
            String randomTranslation = randomWord.getForeign();
            if (!options.contains(randomTranslation)) {
                options.add(randomTranslation);
            }
        }

        // Shuffle the options to randomize the placement of the correct answer
        Collections.shuffle(options);

        // Assign the shuffled options to the buttons
        optionA.setText(options.get(0));
        optionB.setText(options.get(1));
        optionC.setText(options.get(2));
        optionD.setText(options.get(3));
    }

    @FXML
    public void initialize() {
        questionLabel.setText("What is the Spanish translation of '" + correctAnswer.getText() + "'?");
        populateOptions();
    }
}