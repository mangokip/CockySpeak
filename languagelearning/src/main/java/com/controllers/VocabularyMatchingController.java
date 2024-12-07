package com.controllers;

import java.io.IOException;

import com.language.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class VocabularyMatchingController {

    @FXML
    private Button word1Button;
    @FXML
    private Button word2Button;
    @FXML
    private Button word3Button;
    @FXML
    private Button word4Button;

    @FXML
    private Button spanish1Button;
    @FXML
    private Button spanish2Button;
    @FXML
    private Button spanish3Button;
    @FXML
    private Button spanish4Button;

    @FXML
    private Button submitButton;

    @FXML
    private Button nextButton;

    @FXML
    private Label feedbackLabel;

    private Button selectedEnglishButton = null;
    private Button selectedSpanishButton = null;

    @FXML
    private void handleWordAction(ActionEvent event) {
        Button wordButton = (Button) event.getSource();
        if (selectedEnglishButton != null) {
            selectedEnglishButton.setStyle(""); // Reset button style
        }
        selectedEnglishButton = wordButton;
        selectedEnglishButton.setStyle("-fx-background-color: #FFEB3B;"); // Highlight the selected word
    }

    @FXML
    private void handleSpanishAction(ActionEvent event) {
        Button spanishButton = (Button) event.getSource();
        if (selectedSpanishButton != null) {
            selectedSpanishButton.setStyle(""); // Reset button style
        }
        selectedSpanishButton = spanishButton;
        selectedSpanishButton.setStyle("-fx-background-color: #FFEB3B;"); // Highlight the selected word
    }

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
                feedbackLabel.setVisible(true);

                selectedEnglishButton.setDisable(true);
                selectedSpanishButton.setDisable(true);

                selectedEnglishButton = null;
                selectedSpanishButton = null;

                if (areAllButtonsDisabled()) {
                    proceedToNextModule();
                }
            } else {
                feedbackLabel.setText("Incorrect Match! Try Again.");
                feedbackLabel.setStyle("-fx-text-fill: red;");
                feedbackLabel.setVisible(true);

                selectedEnglishButton.setStyle("");
                selectedSpanishButton.setStyle("");
                selectedEnglishButton = null;
                selectedSpanishButton = null;
            }
        } else {
            feedbackLabel.setText("Please select both words before submitting.");
            feedbackLabel.setStyle("-fx-text-fill: orange;");
            feedbackLabel.setVisible(true);
        }
    }

    private boolean areAllButtonsDisabled() {
        return word1Button.isDisabled() && word2Button.isDisabled() &&
               word3Button.isDisabled() && word4Button.isDisabled() &&
               spanish1Button.isDisabled() && spanish2Button.isDisabled() &&
               spanish3Button.isDisabled() && spanish4Button.isDisabled();
    }

    private void proceedToNextModule() {
        nextButton.setVisible(true);
    }

    @FXML
    private void handleNext(ActionEvent event) {
        try {
            App.setRoot("trueFalse");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        feedbackLabel.setText("");
        feedbackLabel.setVisible(false);
        nextButton.setVisible(false);
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
