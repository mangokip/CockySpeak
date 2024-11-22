package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class VocabMatchingController {

    @FXML
    private VBox matchingSection;

    @FXML
    private VBox feedbackSection;

    @FXML
    private Button submitButton;

    @FXML
    private Button nextButton;

    @FXML
    public void initialize() {
        // Set event handler for Submit Button
        submitButton.setOnAction(event -> {
            matchingSection.setVisible(false);  // Hide the matching section
            feedbackSection.setVisible(true);  // Show the feedback section
        });

        // Set event handler for Next Button
        nextButton.setOnAction(event -> {
            System.out.println("Next button clicked!"); // You can implement additional logic
        });
    }
}