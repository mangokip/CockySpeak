package com.controllers;

import java.io.IOException;

import com.language.App;

import javafx.fxml.FXML;

public class ProfileController {

    @FXML
    private void goToHome() throws IOException {
        App.setRoot("primary");
    }
}
