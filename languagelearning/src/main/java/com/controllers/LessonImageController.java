package com.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import java.io.IOException;

public class LessonImageController {
    
    @FXML
    private ImageView flagImageView;
    
    @FXML
    private Ellipse startbutton;
    private static boolean level1Completed = false;

    @FXML
    public void initialize() {
        setupFlagImage();
        //setupNavigation();
    }

    private void setupFlagImage() {
        if (flagImageView != null) {
            Rectangle clip = new Rectangle(
                flagImageView.getFitWidth(), 
                flagImageView.getFitHeight()
            );
            clip.setArcWidth(30);
            clip.setArcHeight(30);
            clip.setStroke(Color.TRANSPARENT);
            
            flagImageView.setClip(clip);
        }
    }

    // private void setupNavigation() {
    //     if (firstCircleButton != null) {
    //         firstCircleButton.setOnMouseClicked(event -> navigateToScreen("/fxml/VocabMatching.fxml"));
    //     }
    // }

    @FXML
private void starbutton() {
    navigateToScreen("/fxml/VocabMatching.fxml");
}

    private void navigateToScreen(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) startbutton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Navigation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void handleHome() {
        navigateToScreen("/fxml/Home.fxml");
    }

    @FXML
    private void handleRanking() {
        navigateToScreen("/fxml/Ranking.fxml");
    }

    @FXML
    private void handleFlashcards() {
        navigateToScreen("/fxml/Flashcards.fxml");
    }

    @FXML
    private void handleProfile() {
        navigateToScreen("/fxml/Profile.fxml");
    }
}
