package com.controllers;

import com.language.App;
import com.model.CockySpeak;
import com.model.Language;
import com.model.Lesson;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LessonImageController {

    private CockySpeak cockySpeak;

    @FXML
    public void initialize() {
        cockySpeak = CockySpeak.getInstance();
    }

    @FXML
private void handleStartLesson() {
    try {
        // Create a new lesson and set it in the App
        Lesson lesson = new Lesson("Module 1", new Language("Spanish"));
        App.setCurrentLesson(lesson);

        // Navigate directly to the first lesson screen
        App.setRoot("multipleChoice");
    } catch (Exception e) {
        showErrorPopup("Error", "Failed to start the lesson.");
    }
}


    @FXML
    private void handleHome() {
        System.out.println("Home button clicked.");
    }

    @FXML
    private void handleRanking() {
        System.out.println("Ranking button clicked.");
    }

    @FXML
    private void handleFlashcards() {
        System.out.println("Flashcards button clicked.");
    }

    @FXML
    private void handleProfile() {
        System.out.println("Profile button clicked.");
    }

    private void showErrorPopup(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
