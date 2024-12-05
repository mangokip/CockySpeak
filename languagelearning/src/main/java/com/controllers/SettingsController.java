package com.controllers;

import java.io.IOException;

import com.language.App;
import com.model.CockySpeak;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class SettingsController {

    @FXML
    private VBox usernameFields, passwordFields, emailFields;

    @FXML
    private TextField currentUsername, newUsername;
    @FXML
    private TextField currentPassword, newPassword;
    @FXML
    private TextField currentEmail, newEmail;

    private CockySpeak cockySpeak = CockySpeak.getInstance();

    // Toggle the visibility of username input fields
    @FXML
    private void showUsernameFields() {
        toggleVisibility(usernameFields);
    }

    // Toggle the visibility of password input fields
    @FXML
    private void showPasswordFields() {
        toggleVisibility(passwordFields);
    }

    // Toggle the visibility of email input fields
    @FXML
    private void showEmailFields() {
        toggleVisibility(emailFields);
    }

    // Confirm username change
    @FXML
    private void confirmUsernameChange() {
        String current = currentUsername.getText();
        String newUser = newUsername.getText();

        if (newUser.isEmpty() || !current.equals(cockySpeak.getCurrentUser().getUserName())) {
            System.out.println("Invalid username change request.");
            return;
        }

        cockySpeak.changeUsername(newUser);
        System.out.println("Username updated!");
        clearFields(currentUsername, newUsername);
        toggleVisibility(usernameFields);
    }

    // Confirm password change
    @FXML
    private void confirmPasswordChange() {
        String current = currentPassword.getText();
        String newPass = newPassword.getText();

        if (newPass.isEmpty() || !current.equals(cockySpeak.getCurrentUser().getPassword())) {
            System.out.println("Invalid password change request.");
            return;
        }

        cockySpeak.changePassword(newPass);
        System.out.println("Password updated!");
        clearFields(currentPassword, newPassword);
        toggleVisibility(passwordFields);
    }

    // Confirm email change
    @FXML
    private void confirmEmailChange() {
        String current = currentEmail.getText();
        String newMail = newEmail.getText();

        if (newMail.isEmpty() || !current.equals(cockySpeak.getCurrentUser().getEmail())) {
            System.out.println("Invalid email change request.");
            return;
        }

        cockySpeak.getCurrentUser().setEmail(newMail);
        System.out.println("Email updated!");
        clearFields(currentEmail, newEmail);
        toggleVisibility(emailFields);
    }

    // Logout method
    @FXML
    private void logout() throws IOException {
        cockySpeak.logout();
        App.setRoot("login");
        System.out.println("Logged out successfully.");
    }

    // Navigation Methods
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
        App.setRoot("ranking");
    }

    // Helper Methods
    private void toggleVisibility(VBox fieldGroup) {
        boolean isVisible = fieldGroup.isVisible();
        fieldGroup.setVisible(!isVisible);
        fieldGroup.setManaged(!isVisible);
    }

    private void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }
}
