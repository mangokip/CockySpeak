package com.controllers;

import java.io.IOException;

import com.language.App;

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

    @FXML
    private void handleSignupAction(ActionEvent event) {
        String username = usernameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();

        // TODO: Add signup logic here
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            errorMessage.setVisible(true);
        } else {
            errorMessage.setVisible(false);
            System.out.println("Signup successful with username: " + username);
            // Navigate to another screen if needed
        }
    }

    @FXML
    private void handleBackAction(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
    
}
