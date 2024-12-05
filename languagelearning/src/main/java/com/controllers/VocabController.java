package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VocabController {

    @FXML private Button word1Button;
    @FXML private Button word2Button;
    @FXML private Button word3Button;
    @FXML private Button word4Button;

    @FXML private Button spanish1Button;
    @FXML private Button spanish2Button;
    @FXML private Button spanish3Button;
    @FXML private Button spanish4Button;

    @FXML private Button submitButton;

    @FXML private Label feedbackLabel;

    private Button selectedEnglishButton = null;
    private Button selectedSpanishButton = null;

    // Handles clicking of an English word (left-side button)
    @FXML
    private void handleWordAction(Button wordButton) {
        // If there's already a selected button, unselect it
        if (selectedEnglishButton != null) {
            selectedEnglishButton.setStyle("");  // Reset button style
        }

        // Set this button as selected and change its style
        selectedEnglishButton = wordButton;
        selectedEnglishButton.setStyle("-fx-background-color: #FFEB3B;");  // Highlight the selected word
    }

    // Handles clicking of a Spanish word (right-side button)
    @FXML
    private void handleSpanishAction(Button spanishButton) {
        // If there's already a selected button, unselect it
        if (selectedSpanishButton != null) {
            selectedSpanishButton.setStyle("");  // Reset button style
        }

        // Set this button as selected and change its style
        selectedSpanishButton = spanishButton;
        selectedSpanishButton.setStyle("-fx-background-color: #FFEB3B;");  // Highlight the selected word
    }

    // Handles the "Submit" action to check the match
    @FXML
    private void handleSubmit() {
        if (selectedEnglishButton != null && selectedSpanishButton != null) {
            String englishWord = selectedEnglishButton.getText();
            String spanishWord = selectedSpanishButton.getText();

            // Checking the matching logic
            if ((englishWord.equals("Hello") && spanishWord.equals("Hola")) ||
                (englishWord.equals("Goodbye") && spanishWord.equals("Adiós")) ||
                (englishWord.equals("Thank you") && spanishWord.equals("Gracias")) ||
                (englishWord.equals("Please") && spanishWord.equals("Por favor"))) {
                feedbackLabel.setText("Correct Match!");
                feedbackLabel.setStyle("-fx-text-fill: green;");
            } else {
                feedbackLabel.setText("Incorrect Match! Try Again.");
                feedbackLabel.setStyle("-fx-text-fill: red;");
            }
        } else {
            feedbackLabel.setText("Please select both words before submitting.");
            feedbackLabel.setStyle("-fx-text-fill: orange;");
        }
    }

    // Handles the navigation buttons (similar to previous bottom bar)
    @FXML
    private void handleHome() {
        // Implement navigation logic to Home
        System.out.println("Navigating to Home");
    }

    @FXML
    private void handleRanking() {
        // Implement navigation logic to Ranking
        System.out.println("Navigating to Ranking");
    }

    @FXML
    private void handleFlashcards() {
        // Implement navigation logic to Flashcards
        System.out.println("Navigating to Flashcards");
    }

    @FXML
    private void handleProfile() {
        // Implement navigation logic to Profile
        System.out.println("Navigating to Profile");
    }

    // Initialize feedback label (hidden initially)
    @FXML
    private void initialize() {
        feedbackLabel.setText("");
        feedbackLabel.setVisible(false);
    }
}
