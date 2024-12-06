package com.controllers;

import java.util.List;

import com.model.FillBlank;
import com.model.Word;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FillBlankController {

    @FXML private Label questionPrompt;
    @FXML private Label phraseText;
    @FXML private Button answerOption1;
    @FXML private Button answerOption2;
    @FXML private Button answerOption3;
    @FXML private Button answerOption4;
    @FXML private Button submitButton;

    private FillBlank currentQuestion;
    private int selectedAnswer = -1;

    public void loadNewQuestion(FillBlank question) {
        this.currentQuestion = question;

        phraseText.setText(currentQuestion.getPhraseText());
        List<Word> options = currentQuestion.getAnswerOptions();
        answerOption1.setText(options.get(0).getForeign());
        answerOption2.setText(options.get(1).getForeign());
        answerOption3.setText(options.get(2).getForeign());
        answerOption4.setText(options.get(3).getForeign());

        selectedAnswer = -1;
        resetButtonStyles();
    }

    @FXML
    private void handleOption1() {
        selectedAnswer = 0;
        highlightSelectedOption(answerOption1);
    }

    @FXML
    private void handleOption2() {
        selectedAnswer = 1;
        highlightSelectedOption(answerOption2);
    }

    @FXML
    private void handleOption3() {
        selectedAnswer = 2;
        highlightSelectedOption(answerOption3);
    }

    @FXML
    private void handleOption4() {
        selectedAnswer = 3;
        highlightSelectedOption(answerOption4);
    }

    private void highlightSelectedOption(Button selectedButton) {
        resetButtonStyles();
        selectedButton.setStyle("-fx-background-color: #d04d3b; -fx-text-fill: white;"); // Darker shade
    }

    private void resetButtonStyles() {
        String defaultStyle = "-fx-background-color: #f06179; -fx-border-color: #bbb; -fx-font-size: 14px;";
        answerOption1.setStyle(defaultStyle);
        answerOption2.setStyle(defaultStyle);
        answerOption3.setStyle(defaultStyle);
        answerOption4.setStyle(defaultStyle);
    }

    @FXML
    private void handleSubmit() {
        if (selectedAnswer != -1) {
            Word selectedWord = currentQuestion.getAnswerOptions().get(selectedAnswer);
            if (currentQuestion.validateAnswer(String.valueOf(selectedAnswer + 1))) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is: " + currentQuestion.getCorrectAnswer().getForeign());
            }
        } else {
            System.out.println("No option selected. Please choose an answer.");
        }
    }
}
