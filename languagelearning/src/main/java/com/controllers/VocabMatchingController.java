package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

public class VocabMatchingController {

    // Sections
    @FXML
    private VBox matchingSection;
    @FXML
    private VBox feedbackSection;

    // Buttons
    @FXML
    private Button submitButton;
    @FXML
    private Button nextButton;

    // Matching Toggle Buttons
    @FXML
    private ToggleButton togglePerro;
    @FXML
    private ToggleButton toggleAgua;
    @FXML
    private ToggleButton toggleCasa;
    @FXML
    private ToggleButton toggleLibro;
    @FXML
    private ToggleButton toggleManzana;

    @FXML
    public void initialize() {
        setupMatchingSection();
    }

    /**
     * Sets up the logic for the matching section.
     */
    private void setupMatchingSection() {
        submitButton.setOnAction(event -> {
            if (validateAnswers()) {
                // Switch to feedback section on correct answers
                matchingSection.setVisible(false);
                feedbackSection.setVisible(true);
            } else {
                System.out.println("Incorrect answers. Please try again.");
            }
        });

        nextButton.setOnAction(event -> {
            System.out.println("Navigating to next module...");
            // Implement navigation logic for the next module here
        });
    }

    /**
     * Validates the user's matching answers.
     * @return true if all answers are correct, false otherwise
     */
    private boolean validateAnswers() {
        // Add logic here to check if the toggle buttons are correctly selected.
        return togglePerro.isSelected() &&
               toggleAgua.isSelected() &&
               toggleCasa.isSelected() &&
               toggleLibro.isSelected() &&
               toggleManzana.isSelected();
    }

    // Handlers for Bottom Navigation

    @FXML
    private void handleHome() {
        System.out.println("Navigating to Home...");
        // Add navigation logic to go back to the home screen
    }

    @FXML
    private void handleRanking() {
        System.out.println("Navigating to Ranking...");
        // Add navigation logic to go to the ranking screen
    }

    @FXML
    private void handleFlashcards() {
        System.out.println("Navigating to Flashcards...");
        // Add navigation logic to go to flashcards
    }

    @FXML
    private void handleProfile() {
        System.out.println("Navigating to Profile...");
        // Add navigation logic to go to profile screen
    }
}