package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MultipleChoiceController {

    @FXML
    private Label questionLabel;

    @FXML
    private Button option1Button;

    @FXML
    private Button option2Button;

    @FXML
    private Button option3Button;

    @FXML
    private Button option4Button;

    public void initialize() {
        // Load the question and options dynamically
        questionLabel.setText("What is the correct translation for 'Hola'?");
        option1Button.setText("Hello");
        option2Button.setText("Goodbye");
        option3Button.setText("Please");
        option4Button.setText("Thank you");
    }

    @FXML
    private void handleOption(MouseEvent event) {
        Button selectedButton = (Button) event.getSource();
        String userAnswer = selectedButton.getText();

        if (validateAnswer(userAnswer)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer!");
        }
    }

    private boolean validateAnswer(String userAnswer) {
        // This is an example. Replace with actual validation logic.
        return "Hello".equals(userAnswer);
    }

    @FXML
    private void handleHome(MouseEvent event) {
        System.out.println("Navigating to Home");
    }

    @FXML
    private void handleRanking(MouseEvent event) {
        System.out.println("Navigating to Ranking");
    }

    @FXML
    private void handleFlashcards(MouseEvent event) {
        System.out.println("Navigating to Flashcards");
    }

    @FXML
    private void handleProfile(MouseEvent event) {
        System.out.println("Navigating to Profile");
    }
}
