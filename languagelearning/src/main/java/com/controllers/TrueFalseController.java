/** 
package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TrueFalseController {

    @FXML
    private Label questionLabel;

    @FXML
    private Button trueButton;

    @FXML
    private Button falseButton;

    @FXML
    private Label feedbackLabel;

    private boolean correctAnswer; // Set this dynamically when loading a question

    public void initialize() {
        feedbackLabel.setVisible(false); // Hide feedback initially
    }

    // Handle True button click
    @FXML
    private void handleTrueButton(MouseEvent event) {
        checkAnswer(true);
    }

    // Handle False button click
    @FXML
    private void handleFalseButton(MouseEvent event) {
        checkAnswer(false);
    }

    // Method to check the user's answer
    private void checkAnswer(boolean userAnswer) {
        feedbackLabel.setVisible(true);
        if (userAnswer == correctAnswer) {
            feedbackLabel.setText("Correct!");
            feedbackLabel.setStyle("-fx-text-fill: green;");
        } else {
            feedbackLabel.setText("Incorrect!");
            feedbackLabel.setStyle("-fx-text-fill: red;");
        }
    }

    // Method to load a question and set correctAnswer
    public void loadQuestion(String question, boolean isCorrect) {
        questionLabel.setText(question);
        correctAnswer = isCorrect;
        feedbackLabel.setVisible(false);
    }
}
*/

package com.controllers;

import com.model.Lesson;
import com.model.Question;
import com.model.TrueFalse;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TrueFalseController {

    @FXML
    private Label questionLabel;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Button trueButton;

    @FXML
    private Button falseButton;

    private Lesson currentLesson; // Reference to the Lesson instance
    private int currentQuestionIndex = 0;

    public void initialize() {
        feedbackLabel.setVisible(false); // Hide feedback initially
    }

    // Set the Lesson instance for this controller
    public void setLesson(Lesson lesson) {
        this.currentLesson = lesson;
        loadCurrentQuestion(); // Load the first question
    }

    private void loadCurrentQuestion() {
        if (currentLesson != null && currentQuestionIndex < currentLesson.getQuestions().size()) {
            Question question = currentLesson.getCurrentQuestion(currentQuestionIndex);
            if (question instanceof TrueFalse) {
                TrueFalse trueFalseQuestion = (TrueFalse) question;
                questionLabel.setText(trueFalseQuestion.getPrompt());
                feedbackLabel.setVisible(false);
            }
        } else {
            endLesson();
        }
    }

    @FXML
    private void handleTrueButton(MouseEvent event) {
        processAnswer(true);
    }

    @FXML
    private void handleFalseButton(MouseEvent event) {
        processAnswer(false);
    }

    private void processAnswer(boolean userAnswer) {
        if (currentLesson == null) return;

        Question question = currentLesson.getCurrentQuestion(currentQuestionIndex);
        if (question instanceof TrueFalse) {
            TrueFalse trueFalseQuestion = (TrueFalse) question;
            boolean isCorrect = trueFalseQuestion.validateAnswer(userAnswer ? "1" : "2");
            feedbackLabel.setVisible(true);
            feedbackLabel.setText(isCorrect ? "Correct!" : "Incorrect!");
            feedbackLabel.setStyle("-fx-text-fill: " + (isCorrect ? "green;" : "red;"));
            currentQuestionIndex++;
            loadCurrentQuestion(); // Load the next question
        }
    }

    private void endLesson() {
        questionLabel.setText("Lesson complete!");
        trueButton.setDisable(true);
        falseButton.setDisable(true);
        feedbackLabel.setVisible(false);
    }
}
