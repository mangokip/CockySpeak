package com.controllers;

import java.io.IOException;

import com.language.App;
import com.model.CockySpeak;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class signupController {

    @FXML private TextField usernameField;
    @FXML private TextField emailField;
    @FXML private TextField passwordField;
    @FXML private Button signupButton;
    @FXML private Button backButton;
    @FXML private Label errorMessage;

    private CockySpeak cockySpeak = CockySpeak.getInstance();

    @FXML
    private void handleSignupAction(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // TODO: Add signup logic here
        if (cockySpeak.register(username, password, email)) {
            App.setRoot("login");
        } else {
            errorMessage.setText("Username already exists.");
        }
    }

    @FXML
    private void handleBackAction(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    
}
