package com.controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.language.App;
import com.model.Lesson;
import com.model.MultipleChoice;
import com.model.Question;
import com.model.WordList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MultipleChoiceController {

    private Lesson currentLesson;
    private int currentQuestionIndex;
    private WordList wordList = WordList.getInstance();

    @FXML
    private Label questionLabel;

    @FXML
    private Label feedbackLabel;

    @FXML
    private Button optionA;

    @FXML
    private Button optionB;

    @FXML
    private Button optionC;

    @FXML
    private Button optionD;

    @FXML
    private Button nextButton;

    @FXML
    public void initialize() {
        feedbackLabel.setVisible(false);
        nextButton.setVisible(false);

        currentLesson = App.getCurrentLesson();
        currentQuestionIndex = 0;

        loadCurrentQuestion();
    }

    private void loadCurrentQuestion() {
        if (currentLesson != null && currentQuestionIndex < currentLesson.getQuestions().size()) {
            Question question = currentLesson.getCurrentQuestion(currentQuestionIndex);
            if (question instanceof MultipleChoice) {
                MultipleChoice mcQuestion = (MultipleChoice) question;
                questionLabel.setText(mcQuestion.getPrompt());
                populateOptions(mcQuestion);
                feedbackLabel.setVisible(false);
            }
        } else {
            navigateToNextLesson();
        }
    }

    private void populateOptions(MultipleChoice mcQuestion) {
        // Fetch the options as a list of strings
        List<String> options = mcQuestion.getAnswerOptions();
        Collections.shuffle(options); // Randomize the options
    
        // Assign the shuffled options to the buttons
        optionA.setText(options.get(0));
        optionB.setText(options.get(1));
        optionC.setText(options.get(2));
        optionD.setText(options.get(3));
    }
    

    @FXML
    private void handleOptionA() {
        checkAnswer(optionA.getText());
    }

    @FXML
    private void handleOptionB() {
        checkAnswer(optionB.getText());
    }

    @FXML
    private void handleOptionC() {
        checkAnswer(optionC.getText());
    }

    @FXML
    private void handleOptionD() {
        checkAnswer(optionD.getText());
    }

    private void checkAnswer(String selectedAnswer) {
        // Assuming `currentLesson` and `currentQuestionIndex` are properly initialized
        Question question = currentLesson.getCurrentQuestion(currentQuestionIndex);
    
        if (question instanceof MultipleChoice) {
            MultipleChoice mcQuestion = (MultipleChoice) question;
    
            // Get the correct answer
            String correctAnswer = mcQuestion.getCorrectAnswer().getForeign();
    
            // Compare the selected answer text to the correct answer
            if (selectedAnswer.equals(correctAnswer)) {
                feedbackLabel.setText("Correct! Great job!");
                feedbackLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            } else {
                feedbackLabel.setText("Incorrect! The correct answer is: " + correctAnswer);
                feedbackLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            }
    
            // Show feedback and prepare for the next question
            feedbackLabel.setVisible(true);
            nextButton.setVisible(true);
    
            // Disable all buttons to prevent further clicks
            disableOptions();
        }
    }
    
    

    private void disableOptions() {
        optionA.setDisable(true);
        optionB.setDisable(true);
        optionC.setDisable(true);
        optionD.setDisable(true);
    }

    @FXML
    private void nextButtonAction() {
        currentQuestionIndex++;
        loadCurrentQuestion();
    }

    private void navigateToNextLesson() {
        try {
            App.setRoot("vocabMatching");
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

