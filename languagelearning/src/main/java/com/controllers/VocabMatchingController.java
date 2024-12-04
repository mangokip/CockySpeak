package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import java.util.HashMap;
import java.util.Map;

public class VocabMatchingController {

    @FXML
    private GridPane matchingGrid;

    private Map<Button, String> wordPairs = new HashMap<>(); // Store word-button associations for checking

    public void initialize() {
        // Example to populate grid; replace with dynamic data
        addWordPair("Casa", "House");
        addWordPair("Perro", "Dog");
        addWordPair("Gato", "Cat");
    }

    private void addWordPair(String word, String translation) {
        Button wordButton = new Button(word);
        Button translationButton = new Button(translation);

        wordButton.setOnAction(this::handleWordClick);
        translationButton.setOnAction(this::handleWordClick);

        matchingGrid.add(wordButton, 0, matchingGrid.getRowCount());
        matchingGrid.add(translationButton, 1, matchingGrid.getRowCount());
        
        wordPairs.put(wordButton, translation);
        wordPairs.put(translationButton, word);
    }

    @FXML
    private void handleWordClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String text = clickedButton.getText();
        clickedButton.setStyle("-fx-background-color: yellow;"); // Highlight selected

        // Match logic placeholder, adjust as needed.
        String expectedMatch = wordPairs.get(clickedButton);
        // Provide feedback logic, call other methods accordingly.
    }
}
