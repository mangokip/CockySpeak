package com.controllers;

import java.io.IOException;

import com.language.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class FlashcardMenuController {

    @FXML
    private Button lesson1Flashcards;


    @FXML
    void loadLessonFlashcards(ActionEvent event) throws IOException {
        App.setRoot("lesson1flash");
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
    void handleProfile(MouseEvent event) throws IOException{
        App.setRoot("profile");
    }

    @FXML
    void handleRanking(MouseEvent event) throws IOException {
        App.setRoot("ranking");
    }

}
