package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;
import java.util.Map;

public class VocabMatchingController {

    @FXML
    private GridPane matchingGrid;

    @FXML
    private Button submitButton;

    @FXML
    private Label feedbackLabel;

    // Store correct and user matches
    private final Map<Button, String> correctMatches = new HashMap<>();
    private final Map<Button, String> userMatches = new HashMap<>();

    public void initialize() {
        // Example: Set correct matches. Replace these with dynamic data from your model.
        correctMatches.put(new Button("Apple"), "Manzana");
        correctMatches.put(new Button("Dog"), "Perro");
        correctMatches.put(new Button("House"), "Casa");

        feedbackLabel.setVisible(false);
    }

    /**
     * Handles button clicks for word selections.
     * Updates the user’s choices.
     */
    @FXML
    private void handleSelection(MouseEvent event) {
        Button selectedButton = (Button) event.getSource();
        String translation = selectedButton.getText();

        // Assume English words are in the first column of matchingGrid
        int rowIndex = GridPane.getRowIndex(selectedButton);

        // Get English word from the corresponding button in the first column
        Button englishWordButton = (Button) matchingGrid.getChildren().get(rowIndex * 2); 
        String englishWord = englishWordButton.getText();

        userMatches.put(englishWordButton, translation);
    }

    /**
     * Handles the submit button click.
     * Checks user's matches and provides feedback.
     */
    @FXML
    private void handleSubmit() {
        if (checkMatches()) {
            feedbackLabel.setText("Correct! Great job.");
            feedbackLabel.setStyle("-fx-text-fill: green;");
        } else {
            feedbackLabel.setText("Incorrect matches. Try again!");
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }
        feedbackLabel.setVisible(true);
    }

    /**
     * Checks if the user's matches are correct.
     *
     * @return true if all matches are correct, false otherwise.
     */
    private boolean checkMatches() {
        for (Map.Entry<Button, String> entry : correctMatches.entrySet()) {
            Button englishWordButton = entry.getKey();
            String correctTranslation = entry.getValue();

            String userTranslation = userMatches.getOrDefault(englishWordButton, "");

            if (!correctTranslation.equals(userTranslation)) {
                return false;
            }
        }
        return true;
    }
}