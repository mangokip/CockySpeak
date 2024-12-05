package com.controllers;

import java.io.IOException;

import com.language.App;
import com.narration.Narriator;
import com.model.CockySpeak;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class loginController {

    //initialize fxml elements
    @FXML private TextField userNameTextField;
    @FXML private TextField passwordTextField;
    @FXML private Button loginButton;
    @FXML private Button signupButton;
    @FXML private Label errorMessage;

    //initalize cockyspeak
    private CockySpeak cockySpeak = new CockySpeak();
    private String userName;
    private String password;


    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        userName = userNameTextField.getText();
        password = passwordTextField.getText();
        // errorMessage.setVisible(true);

        try{
            cockySpeak.login(userName, password);
            App.setRoot("flashcard");
        } catch (Exception e) {
            errorMessage.setVisible(true);
        }
    }
    @FXML
    private void switchToSecondary() throws IOException {
        Narriator.playSound("Je mapell HELLO WORLD!");
        App.setRoot("secondary");
    }
    
}
