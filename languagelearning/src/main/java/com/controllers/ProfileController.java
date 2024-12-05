package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ProfileController {

    // FXML elements for the profile screen
    @FXML
    private ImageView logoImage; // Logo ImageView
    @FXML
    private ImageView avatarImage; // Avatar ImageView
    @FXML
    private PieChart progressChart; // Progress PieChart
    @FXML
    private PieChart.Data progressSlice; // PieChart Data for progress
    @FXML
    private Label xpLabel; // Label for XP
    @FXML
    private Label streakLabel; // Label for streak (e.g., 2 Days)

    // Initialize the profile screen
    @FXML
private void initialize() {
    // Set the images for the logo and avatar
    logoImage.setImage(new Image(getClass().getResource("/images/Cockylogo.png").toExternalForm()));
    avatarImage.setImage(new Image(getClass().getResource("/images/Avatar.png").toExternalForm()));

    // Set progress chart data
    progressSlice = new PieChart.Data("Progress", 70); // Update to 70% progress
    progressChart.getData().add(progressSlice);

    // Set initial XP and streak labels
    xpLabel.setText("XP: 1200");
    streakLabel.setText("Streak: 2 Days");

    // Apply CSS styles
    logoImage.getStyleClass().add("logo-image");
    avatarImage.getStyleClass().add("avatar-image");
    progressChart.getStyleClass().add("progress-chart");
    xpLabel.getStyleClass().add("profile-label");
    streakLabel.getStyleClass().add("profile-label");
}
    // Action when clicking the "Settings" button
    @FXML
    private void goToSettings() {
        // Add your logic to navigate to settings page
        System.out.println("Navigating to Settings...");
    }

    // Action when clicking the "Logout" button
    @FXML
    private void handleLogout() {
        // Add your logic for handling logout (e.g., logout the user and redirect)
        System.out.println("Logging out...");
    }

    // Handle the navigation actions for the bottom bar buttons

    // Action for Home button in the bottom navigation bar
    @FXML
    private void handleHome(MouseEvent event) {
        System.out.println("Navigating to Home...");
    }

    // Action for Ranking button in the bottom navigation bar
    @FXML
    private void handleRanking(MouseEvent event) {
        System.out.println("Navigating to Ranking...");
    }

    // Action for Flashcards button in the bottom navigation bar
    @FXML
    private void handleFlashcards(MouseEvent event) {
        System.out.println("Navigating to Flashcards...");
    }

    // Action for Profile button in the bottom navigation bar
    @FXML
    private void handleProfile(MouseEvent event) {
        System.out.println("Navigating to Profile...");
    }
}
