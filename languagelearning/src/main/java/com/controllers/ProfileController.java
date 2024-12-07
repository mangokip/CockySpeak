package com.controllers;

import java.io.IOException;

import com.language.App;
import com.model.CockySpeak;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ProfileController {

    @FXML
    private ImageView profilePicture;

    @FXML
    private Label nameLabel;

    @FXML
    private PieChart progressChart;

    private CockySpeak cockySpeak = CockySpeak.getInstance();

    @FXML
    public void initialize() {
        // Load profile picture
        try {
            profilePicture.setImage(new Image(App.class.getResourceAsStream("/com/language/images/chicken.png")));

        } catch (Exception e) {
            System.err.println("Error loading profile picture. Setting default.");
            profilePicture.setImage(new Image(App.class.getResourceAsStream("/com/language/images/Cockylogo.png")));

        }

        // Set the username or default to "Guest"
        if (cockySpeak.getCurrentUser() != null) {
            nameLabel.setText(cockySpeak.getCurrentUser().getUserName());
        } else {
            nameLabel.setText("Guest");
        }

        // Populate the progress chart
        populateChart();
    }

    private void populateChart() {
        progressChart.getData().clear();
        if (cockySpeak.getCurrentUser() != null && cockySpeak.getCurrentLanguage() != null) {
            var tracker = cockySpeak.getCurrentUser().getLanguageProgressTracker(cockySpeak.getCurrentLanguage());
            if (tracker != null) {
                int completed = tracker.getCompletedLessons();
                int remaining = Math.max(0, 10 - completed); // Example total lessons: 10
                progressChart.getData().addAll(
                    new PieChart.Data("Completed", completed),
                    new PieChart.Data("Remaining", remaining)
                );
            } else {
                progressChart.getData().addAll(
                    new PieChart.Data("No Data", 1)
                );
            }
        } else {
            progressChart.getData().addAll(
                new PieChart.Data("No Data", 1)
            );
        }
    }

    @FXML
    private void handleLogout() {
        cockySpeak.logout();
        try {
            App.setRoot("login"); // Navigate back to login screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openSettings() {
        try {
            App.setRoot("settings"); // Navigate to settings screen
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        App.setRoot("lesson");
    }
   
}
