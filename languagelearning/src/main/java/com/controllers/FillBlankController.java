package com.controllers;

import java.io.IOException;

import com.language.App;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FillBlankController {

    @FXML
    private Label questionPrompt;

    @FXML
    private Label phraseText;

    @FXML
    private Button answerOption1;

    @FXML
    private Button answerOption2;

    @FXML
    private Button answerOption3;

    @FXML
    private Button answerOption4;

    @FXML
    private Button submitButton;

    @FXML
    private Label feedbackLabel; // Label to display feedback

    private int correctAnswerIndex = 1; // Hardcoded correct answer index (0-based)
    private int selectedAnswer = -1;   // User's selected answer index (-1 means none selected)

    @FXML
    public void initialize() {
        loadHardcodedQuestion();
    }

    /**
     * Hardcoded question and options for Fill-in-the-Blank in Spanish.
     */
    private void loadHardcodedQuestion() {
        questionPrompt.setText("Rellena el espacio en blanco con la palabra correcta:");
        phraseText.setText("Marion ______ agua."); // The blank phrase in Spanish

        // Options in Spanish
        answerOption1.setText("perro");
        answerOption2.setText("necesito"); // Correct answer
        answerOption3.setText("comer");
        answerOption4.setText("gato");

        feedbackLabel.setText(""); // Clear any previous feedback
        resetButtonStyles();
        selectedAnswer = -1; // Reset the selected answer
    }

    // Methods to handle answer options
    @FXML
    private void handleOption1() {
        selectAnswer(0, answerOption1);
    }

    @FXML
    private void handleOption2() {
        selectAnswer(1, answerOption2);
    }

    @FXML
    private void handleOption3() {
        selectAnswer(2, answerOption3);
    }

    @FXML
    private void handleOption4() {
        selectAnswer(3, answerOption4);
    }

    private void selectAnswer(int index, Button button) {
        selectedAnswer = index;
        highlightSelectedOption(button);
    }

    private void highlightSelectedOption(Button selectedButton) {
        resetButtonStyles();
        selectedButton.setStyle("-fx-background-color: #d04d3b; -fx-text-fill: white;"); // Highlight the selected option
    }

    private void resetButtonStyles() {
        String defaultStyle = "-fx-background-color: #f06179; -fx-border-color: #bbb; -fx-font-size: 14px;";
        answerOption1.setStyle(defaultStyle);
        answerOption2.setStyle(defaultStyle);
        answerOption3.setStyle(defaultStyle);
        answerOption4.setStyle(defaultStyle);
    }

    @FXML
    private void handleSubmit() {
        if (selectedAnswer != -1) {
            boolean isCorrect = (selectedAnswer == correctAnswerIndex);
            feedbackLabel.setText(isCorrect ? "¡Correcto! 🎉" : "¡Incorrecto! La respuesta correcta era: 'necesito'.");
            feedbackLabel.setStyle("-fx-text-fill: " + (isCorrect ? "green;" : "red;"));
        } else {
            feedbackLabel.setText("Por favor, selecciona una respuesta.");
            feedbackLabel.setStyle("-fx-text-fill: orange;");
        }
    }

    // Navigation Methods for Bottom Bar
    @FXML
    private void handleHome(MouseEvent event) throws IOException {
        App.setRoot("home"); // Navigate to Home
    }

    @FXML
    private void handleRanking(MouseEvent event) throws IOException {
        App.setRoot("ranking"); // Navigate to Ranking
    }

    @FXML
    private void handleFlashcards(MouseEvent event) throws IOException {
        App.setRoot("flashcard"); // Navigate to Flashcards
    }

    @FXML
    private void handleProfile(MouseEvent event) throws IOException {
        App.setRoot("profile"); // Navigate to Profile
    }
}
