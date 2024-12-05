package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;

public class MultipleChoiceController {

    // FXML elements for question and answers
    @FXML private Label questionLabel;
    @FXML private Label resultLabel;
    @FXML private RadioButton option1;
    @FXML private RadioButton option2;
    @FXML private RadioButton option3;
    @FXML private RadioButton option4;
    @FXML private ToggleGroup choicesGroup;

    // FXML elements for bottom navigation
    @FXML private Button homeButton;
    @FXML private Button rankingButton;
    @FXML private Button flashcardsButton;
    @FXML private Button profileButton;

    // Initialize the scene, set question, options, and default state
    @FXML
    public void initialize() {
        // Set up the question and options
        questionLabel.setText("What is the Spanish word for 'Hello'?");
        option1.setText("Hola");
        option2.setText("Adiós");
        option3.setText("Gracias");
        option4.setText("Por favor");

        // Clear the result label when the screen is first loaded
        resultLabel.setText("");
    }

    // Submit the answer and check correctness
    @FXML
    public void submitAnswer() {
        // Get the selected option from the ToggleGroup
        RadioButton selectedOption = (RadioButton) choicesGroup.getSelectedToggle();

        // If an option is selected
        if (selectedOption != null) {
            String answer = selectedOption.getText();

            // Check if the selected option is correct
            if (answer.equals("Hola")) {
                resultLabel.setText("Correct!");
                resultLabel.setStyle("-fx-text-fill: green;");
            } else {
                resultLabel.setText("Incorrect, try again.");
                resultLabel.setStyle("-fx-text-fill: red;");
            }
        } else {
            // If no option is selected, prompt the user to select an answer
            resultLabel.setText("Please select an answer.");
            resultLabel.setStyle("-fx-text-fill: red;");
        }
    }

    // Handlers for bottom bar navigation
    @FXML
    public void handleHome() {
        // Navigate to Home
    }

    @FXML
    public void handleRanking() {
        // Navigate to Ranking
    }

    @FXML
    public void handleFlashcards() {
        // Navigate to Flashcards
    }

    @FXML
    public void handleProfile() {
        // Navigate to Profile
    }
}
