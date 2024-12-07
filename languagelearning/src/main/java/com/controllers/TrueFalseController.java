package com.controllers;

import java.io.IOException;

import com.language.App;
import com.model.Lesson;
import com.model.Question;
import com.model.TrueFalse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TrueFalseController {

    @FXML
    private Label questionLabel;

    @FXML
    private Label feedbackLabel;

    private Lesson currentLesson;
    private int currentQuestionIndex;

    @FXML
    public void initialize() {
        feedbackLabel.setVisible(false);
        currentLesson = App.getCurrentLesson();
        currentQuestionIndex = 0;
        loadCurrentQuestion();
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
    private void handleTrueAction() {
        processAnswer(true);
    }

    @FXML
    private void handleFalseAction() {
        processAnswer(false);
    }

    private void processAnswer(boolean userAnswer) {
        if (currentLesson == null) return;

        Question question = currentLesson.getCurrentQuestion(currentQuestionIndex);
        if (question instanceof TrueFalse) {
            TrueFalse tfQuestion = (TrueFalse) question;

            boolean isCorrect = tfQuestion.validateAnswer(userAnswer ? "1" : "2");
            feedbackLabel.setText(isCorrect ? "Correct!" : "Incorrect!");
            feedbackLabel.setStyle("-fx-text-fill: " + (isCorrect ? "green;" : "red;"));
            feedbackLabel.setVisible(true);

            currentQuestionIndex++;
            loadCurrentQuestion();
        }
    }

    private void endLesson() {
        try {
            App.setRoot("profile");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    void handleProfile(MouseEvent event) throws IOException {
        App.setRoot("profile");
    }

    @FXML
    void handleRanking(MouseEvent event) throws IOException {
        App.setRoot("ranking");
    }
}
