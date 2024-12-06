package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MultipleChoiceController {

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

    // Correct answer: "Gracias"
    private String correctAnswer = "Gracias";

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
        if (selectedOption.getText().equals(correctAnswer)) {
            feedbackLabel.setText("Correct! Great job!");
            feedbackLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        } else {
            feedbackLabel.setText("Incorrect! Try again.");
            feedbackLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        feedbackLabel.setVisible(true);
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
}