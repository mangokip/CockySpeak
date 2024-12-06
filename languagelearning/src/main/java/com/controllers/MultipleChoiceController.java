package com.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import com.language.App;
import java.io.IOException;

public class MultipleChoiceController implements QuestionController {

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

    // Correct answer: "Gracias"
    private String correctAnswer = "Gracias";

    @FXML
    private void handleOptionA() {
        checkAnswer(optionA);
    }

    @FXML
    private void handleOptionB() {
        checkAnswer(optionB);
    }

    @FXML
    private void handleOptionC() {
        checkAnswer(optionC);
    }

    @FXML
    private void handleOptionD() {
        checkAnswer(optionD);
    }

    /**
     * This method checks the selected answer against the correct one and provides feedback.
     */
    private void checkAnswer(Button selectedOption) {
        boolean isCorrect = selectedOption.getText().equals(correctAnswer);
        if (isCorrect) {
            feedbackLabel.setText("Correct! Great job!");
            feedbackLabel.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
            
            // Add delay then go to next screen
            new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        javafx.application.Platform.runLater(() -> {
                            try {
                                // After multiple choice, go to home
                                App.setRoot("home");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                },
                2000 // 2 second delay
            );
        } else {
            feedbackLabel.setText("Incorrect! Try again.");
            feedbackLabel.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        feedbackLabel.setVisible(true);
    }

    // Navigation handlers
    @FXML void handleHome() throws IOException {
        App.setRoot("home");
    }

    @FXML void handleRanking() throws IOException {
        App.setRoot("ranking");
    }

    @FXML void handleFlashcards() throws IOException {
        App.setRoot("flashcard");
    }

    @FXML void handleProfile() throws IOException {
        App.setRoot("profile");
    }
    
    private QuestionCompletionCallback callback;

    @Override
    public void setCompletionCallback(QuestionCompletionCallback callback) {
        this.callback = callback;
    }

    private void onQuestionAnswered(boolean isCorrect) {
        if (callback != null) {
            callback.onComplete(isCorrect);
        }
    }
}

    //
    //
    //
    //

    
//     private QuestionCompletionCallback callback;

//     @Override
//     public void setCompletionCallback(QuestionCompletionCallback callback) {
//         this.callback = callback;
//     }

//     // Call this when question is answered:
//     private void onQuestionAnswered(boolean isCorrect) {
//         if (callback != null) {
//             callback.onComplete(isCorrect);
//         }
//     }

    
// }

