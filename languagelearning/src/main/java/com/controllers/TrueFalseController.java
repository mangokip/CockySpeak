package com.controllers;

import java.io.IOException;

import com.language.App;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TrueFalseController {

    @FXML
    private Label questionLabel;

    @FXML
    private Label feedbackLabel;

    private String hardcodedQuestion = "Is the translation of 'gato' as 'cat' correct?"; // Hardcoded question
    private boolean correctAnswer = true; // Hardcoded correct answer (true for correct, false for incorrect)

    @FXML
    public void initialize() {
        feedbackLabel.setVisible(false);
        loadHardcodedQuestion();
    }

    private void loadHardcodedQuestion() {
        questionLabel.setText(hardcodedQuestion);
        feedbackLabel.setVisible(false);
    }

    @FXML
    private void handleTrueAction() {
        processAnswer(true);
    }

    @FXML
    private void handleFalseAction() {
        processAnswer(false);
    }

    private void processAnswer(boolean userAnswer) {
        boolean isCorrect = (userAnswer == correctAnswer);
        feedbackLabel.setText(isCorrect ? "Correct!" : "Incorrect!");
        feedbackLabel.setStyle("-fx-text-fill: " + (isCorrect ? "green;" : "red;"));
        feedbackLabel.setVisible(true);

        System.out.println("User selected: " + (userAnswer ? "True" : "False"));
        System.out.println(isCorrect ? "Correct answer!" : "Wrong answer!");
    }

    @FXML
    void handleFlashcards(MouseEvent event) throws IOException {
        App.setRoot("flashcard");
    }

    @FXML
    void handleHome(MouseEvent event) throws IOException {
        App.setRoot("home");
    }

    @FXML
    void handleProfile(MouseEvent event) throws IOException {
        App.setRoot("profile");
    }

    @FXML
    void handleRanking(MouseEvent event) throws IOException {
        App.setRoot("ranking");
    }
}
