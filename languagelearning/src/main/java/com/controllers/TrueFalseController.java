package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TrueFalseController {

    @FXML
    private Label questionLabel;

    @FXML
    private Button trueButton;

    @FXML
    private Button falseButton;

    @FXML
    private Label feedbackLabel;

    private boolean correctAnswer; // Set this dynamically when loading a question

    public void initialize() {
        feedbackLabel.setVisible(false); // Hide feedback initially
    }

    // Handle True button click
    @FXML
    private void handleTrueButton(MouseEvent event) {
        checkAnswer(true);
    }

    // Handle False button click
    @FXML
    private void handleFalseButton(MouseEvent event) {
        checkAnswer(false);
    }

    // Method to check the user's answer
    private void checkAnswer(boolean userAnswer) {
        feedbackLabel.setVisible(true);
        if (userAnswer == correctAnswer) {
            feedbackLabel.setText("Correct!");
            feedbackLabel.setStyle("-fx-text-fill: green;");
        } else {
            feedbackLabel.setText("Incorrect!");
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }
    }

    // Method to load a question and set correctAnswer
    public void loadQuestion(String question, boolean isCorrect) {
        questionLabel.setText(question);
        correctAnswer = isCorrect;
        feedbackLabel.setVisible(false);
    }
}
