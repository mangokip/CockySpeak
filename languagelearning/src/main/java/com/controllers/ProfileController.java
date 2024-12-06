package com.controllers;

import java.io.IOException;
import com.language.App;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class ProfileController {

    @FXML
    private void handleHome(MouseEvent event) throws IOException {
        App.setRoot("home");
    }

    @FXML
    private void handleRanking(MouseEvent event) throws IOException {
        App.setRoot("ranking");
    }

    @FXML
    private void handleFlashcards(MouseEvent event) throws IOException {
        App.setRoot("flashcard");
    }

    @FXML
    private void handleProfile(MouseEvent event) throws IOException {
        App.setRoot("profile");
    }

    @FXML
    private void handleSettings(MouseEvent event) throws IOException {
        App.setRoot("settings"); // Make sure there is a corresponding "settings.fxml"
    }

    @FXML
    private void handleLogout(MouseEvent event) throws IOException {
        App.setRoot("login");
    }
}