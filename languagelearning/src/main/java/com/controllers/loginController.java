package com.controllers;

import java.io.IOException;

import com.language.App;
import com.narration.Narriator;

import javafx.fxml.FXML;

public class loginController {
    @FXML
    private void switchToSecondary() throws IOException {
        Narriator.playSound("Je mapell HELLO WORLD!");
        App.setRoot("secondary");
    }
    
}
