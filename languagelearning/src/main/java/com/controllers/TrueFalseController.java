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

    private boolean correctAnswer;

    /**
     * Initializes the question and correct answer.
     * This would typically be set based on the current question data.
     */
    public void initialize() {
        questionLabel.setText("Is 'Casa' the correct translation for 'House'?");
        correctAnswer = true; // Example correct answer, this should come from your model.
        feedbackLabel.setVisible(false);
    }

    /**
     * Handles the True button click.
     */
    @FXML
    private void handleTrueButton(MouseEvent event) {
        checkAnswer(true);
    }

    /**
     * Handles the False button click.
     */
    @FXML
    private void handleFalseButton(MouseEvent event) {
        checkAnswer(false);
    }

    /**
     * Checks if the user's answer is correct and provides feedback.
     *
     * @param userAnswer The user's selected answer (true or false).
     */
    private void checkAnswer(boolean userAnswer) {
        if (userAnswer == correctAnswer) {
            feedbackLabel.setText("Correct! Well done.");
            feedbackLabel.setStyle("-fx-text-fill: green;");
        } else {
            feedbackLabel.setText("Incorrect. Try again.");
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }
        feedbackLabel.setVisible(true);
    }
}
