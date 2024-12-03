package com.controllers;

import java.io.IOException;
import java.util.List;

import com.language.App;
import com.model.CockySpeak;
import com.model.Flashcard;
import com.narration.Narriator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FlashcardViewController {

    @FXML
    private Label currentFlashcardNumber;

    @FXML
    private Button flipCard;

    @FXML
    private Label foreignLabel;

    @FXML
    private Label englishLabel;

    @FXML
    private Button listenCard;

    @FXML
    private Button nextCard;

    @FXML
    private Button previousCard;

    // CockySpeak instance
    private CockySpeak cockySpeak = new CockySpeak();
    private List<Flashcard> flashcards;
    private int currentIndex = 0; // Tracks the current flashcard index
    private boolean isForeignVisible = true; // Tracks which side is currently visible

    @FXML
    public void initialize() {
        // Load flashcards from CockySpeak
        flashcards = cockySpeak.getFlashcards();


        // Ensure flashcards are available
        if (flashcards == null || flashcards.isEmpty()) {
            foreignLabel.setText("No flashcards available.");
            englishLabel.setText("");
            currentFlashcardNumber.setText("0 / 0");
            return;
        }

        // Display the first flashcard
        updateFlashcardDisplay();
        flipCard.toFront();
    }

    @FXML
    void flip(ActionEvent event) {
        // Toggle visibility between the foreign and English text
        isForeignVisible = !isForeignVisible;
        updateFlashcardVisibility();

        System.out.println("Flashcard flipped.");
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

    @FXML
void listen(ActionEvent event) {
    if (flashcards == null || flashcards.isEmpty()) {
        System.out.println("No flashcard selected to pronounce.");
        return;
    }

    Flashcard currentFlashcard = flashcards.get(currentIndex);
   boolean isPhrase = currentFlashcard.getText().contains(" ") || currentFlashcard.getTranslation().contains(" ");
    if (isPhrase) {
        if (isForeignVisible) {
            // Always play the foreign (Spanish) pronunciation
            Narriator.playSoundEnglish(currentFlashcard.getTranslation());
        } else {
            // Always play the English pronunciation
            Narriator.playSound(currentFlashcard.getText());
        }
    } else {
        // Play the correct sound based on visibility
        if (isForeignVisible) {
             // Always play the foreign (Spanish) pronunciation
             Narriator.playSoundEnglish(currentFlashcard.getText());
         } else {
            // Always play the English pronunciation
            Narriator.playSound(currentFlashcard.getTranslation());
        }
    }
}

    
    
    @FXML
    void next(ActionEvent event) {
        // Move to the next flashcard
        if (currentIndex < flashcards.size() - 1) {
            currentIndex++;
            isForeignVisible = true; // Reset to show the foreign word by default
            updateFlashcardDisplay();
        } else {
            System.out.println("You are at the last flashcard.");
        }
    }

    @FXML
    void previous(ActionEvent event) {
        // Move to the previous flashcard
        if (currentIndex > 0) {
            currentIndex--;
            isForeignVisible = true; // Reset to show the foreign word by default
            updateFlashcardDisplay();
        } else {
            System.out.println("You are at the first flashcard.");
        }
    }

    private void updateFlashcardDisplay() {
        Flashcard currentFlashcard = flashcards.get(currentIndex);
    
        // Detect if the current flashcard is a phrase (contains spaces)
        boolean isPhrase = currentFlashcard.getText().contains(" ") || currentFlashcard.getTranslation().contains(" ");
    
        if (isPhrase) {
            // Swap the values for phrases
            foreignLabel.setText(currentFlashcard.getTranslation());
            englishLabel.setText(currentFlashcard.getText());
        } else {
            // Keep values as they are for single words
            foreignLabel.setText(currentFlashcard.getText());
            englishLabel.setText(currentFlashcard.getTranslation());
        }
    
        // Update the flashcard number
        currentFlashcardNumber.setText((currentIndex + 1) + " / " + flashcards.size());
    
        // Ensure the foreign label is visible by default
        isForeignVisible = true;
        updateFlashcardVisibility();
    }
    
    
    

    /**
     * Updates the visibility of the labels based on the current side.
     */
    private void updateFlashcardVisibility() {
        if (isForeignVisible) {
            foreignLabel.setVisible(true);
            englishLabel.setVisible(false);
        } else {
            foreignLabel.setVisible(false);
            englishLabel.setVisible(true);
        }
    }
}
