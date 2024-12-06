// package com.controllers;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.layout.VBox;

// public class VocabController implements QuestionController{

//     @FXML private Button word1Button;
//     @FXML private Button word2Button;
//     @FXML private Button word3Button;
//     @FXML private Button word4Button;

//     @FXML private Button spanish1Button;
//     @FXML private Button spanish2Button;
//     @FXML private Button spanish3Button;
//     @FXML private Button spanish4Button;

//     @FXML private Button submitButton;

//     @FXML private Label feedbackLabel;

//     private Button selectedEnglishButton = null;
//     private Button selectedSpanishButton = null;

//     // Handles clicking of an English word (left-side button)




//     // @FXML
//     // private void handleWordAction(Button wordButton) {
//     //     // If there's already a selected button, unselect it
//     //     if (selectedEnglishButton != null) {
//     //         selectedEnglishButton.setStyle("");  // Reset button style
//     //     }

//     //     // Set this button as selected and change its style
//     //     selectedEnglishButton = wordButton;
//     //     selectedEnglishButton.setStyle("-fx-background-color: #FFEB3B;");  // Highlight the selected word
//     // }






//     // Handles clicking of a Spanish word (right-side button)
//     @FXML
//     private void handleSpanishAction(Button spanishButton) {
//         // If there's already a selected button, unselect it
//         if (selectedSpanishButton != null) {
//             selectedSpanishButton.setStyle("");  // Reset button style
//         }

//         // Set this button as selected and change its style
//         selectedSpanishButton = spanishButton;
//         selectedSpanishButton.setStyle("-fx-background-color: #FFEB3B;");  // Highlight the selected word
//     }

//     // Handles the "Submit" action to check the match
//     @FXML
//     private void handleSubmit() {
//         if (selectedEnglishButton != null && selectedSpanishButton != null) {
//             String englishWord = selectedEnglishButton.getText();
//             String spanishWord = selectedSpanishButton.getText();

//             // Checking the matching logic
//             if ((englishWord.equals("Hello") && spanishWord.equals("Hola")) ||
//                 (englishWord.equals("Goodbye") && spanishWord.equals("Adiós")) ||
//                 (englishWord.equals("Thank you") && spanishWord.equals("Gracias")) ||
//                 (englishWord.equals("Please") && spanishWord.equals("Por favor"))) {
//                 feedbackLabel.setText("Correct Match!");
//                 feedbackLabel.setStyle("-fx-text-fill: green;");
//             } else {
//                 feedbackLabel.setText("Incorrect Match! Try Again.");
//                 feedbackLabel.setStyle("-fx-text-fill: red;");
//             }
//         } else {
//             feedbackLabel.setText("Please select both words before submitting.");
//             feedbackLabel.setStyle("-fx-text-fill: orange;");
//         }
//     }

    

//     // Handles the navigation buttons (similar to previous bottom bar)
//     @FXML
//     private void handleHome() {
//         // Implement navigation logic to Home
//         System.out.println("Navigating to Home");
//     }

//     @FXML
// private void handle1WordAction(ActionEvent event) {
//     handleWordAction(word1Button);
// }

// @FXML
// private void handle2WordAction(ActionEvent event) {
//     handleWordAction(word2Button);
// }

// @FXML
// private void handle3WordAction(ActionEvent event) {
//     handleWordAction(word3Button);
// }

// @FXML
// private void handle4WordAction(ActionEvent event) {  // Note: your FXML has a typo "handl4eWordAction"
//     handleWordAction(word4Button);
// }

// // Make this method private instead of FXML
// private void handleWordAction(Button wordButton) {
//      // If there's already a selected button, unselect it
//      if (selectedEnglishButton != null) {
//         selectedEnglishButton.setStyle("");  // Reset button style
//     }

//     // Set this button as selected and change its style
//     selectedEnglishButton = wordButton;
//     selectedEnglishButton.setStyle("-fx-background-color: #FFEB3B;");  // Highlight the selected word
// }

//     @FXML
//     private void handleRanking() {
//         // Implement navigation logic to Ranking
//         System.out.println("Navigating to Ranking");
//     }

//     @FXML
//     private void handleFlashcards() {
//         // Implement navigation logic to Flashcards
//         System.out.println("Navigating to Flashcards");
//     }

//     @FXML
//     private void handleProfile() {
//         // Implement navigation logic to Profile
//         System.out.println("Navigating to Profile");
//     }

//     // Initialize feedback label (hidden initially)
//     @FXML
//     private void initialize() {
//         feedbackLabel.setText("");
//         feedbackLabel.setVisible(false);
//     }


//     //
//     //
//     //
//     //
    
//         private QuestionCompletionCallback callback;
    
//         @Override
//         public void setCompletionCallback(QuestionCompletionCallback callback) {
//             this.callback = callback;
//         }
    
//         // Call this when question is answered:
//         private void onQuestionAnswered(boolean isCorrect) {
//             if (callback != null) {
//                 callback.onComplete(isCorrect);
//             }
//         }
//     }



package com.controllers;

import java.io.IOException;

import com.language.App;

import javafx.event.ActionEvent;  // Add this import
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class VocabController implements QuestionController {

    @FXML private Button word1Button;
    @FXML private Button word2Button;
    @FXML private Button word3Button;
    @FXML private Button word4Button;
    @FXML private Button spanish1Button;
    @FXML private Button spanish2Button;
    @FXML private Button spanish3Button;
    @FXML private Button spanish4Button;
    @FXML private Button submitButton;
    @FXML private Label feedbackLabel;

    private Button selectedEnglishButton = null;
    private Button selectedSpanishButton = null;

    // English word handlers
    @FXML
    private void handle1WordAction(ActionEvent event) {
        handleWordAction(word1Button);
    }

    @FXML
    private void handle2WordAction(ActionEvent event) {
        handleWordAction(word2Button);
    }

    @FXML
    private void handle3WordAction(ActionEvent event) {
        handleWordAction(word3Button);
    }

    @FXML
    private void handle4WordAction(ActionEvent event) {
        handleWordAction(word4Button);
    }

    // Spanish word handlers
    @FXML
    private void handleSpanish1Action(ActionEvent event) {
        handleSpanishAction(spanish1Button);
    }

    @FXML
    private void handleSpanish2Action(ActionEvent event) {
        handleSpanishAction(spanish2Button);
    }

    @FXML
    private void handleSpanish3Action(ActionEvent event) {
        handleSpanishAction(spanish3Button);
    }

    @FXML
    private void handleSpanish4Action(ActionEvent event) {
        handleSpanishAction(spanish4Button);
    }

    // Helper methods
    private void handleWordAction(Button wordButton) {
        if (selectedEnglishButton != null) {
            selectedEnglishButton.setStyle("");
        }
        selectedEnglishButton = wordButton;
        selectedEnglishButton.setStyle("-fx-background-color: #FFEB3B;");
    }

    private void handleSpanishAction(Button spanishButton) {
        if (selectedSpanishButton != null) {
            selectedSpanishButton.setStyle("");
        }
        selectedSpanishButton = spanishButton;
        selectedSpanishButton.setStyle("-fx-background-color: #FFEB3B;");
    }

    // @FXML
    // private void handleSubmit(ActionEvent event) {
    //     if (selectedEnglishButton != null && selectedSpanishButton != null) {
    //         String englishWord = selectedEnglishButton.getText();
    //         String spanishWord = selectedSpanishButton.getText();
    //         boolean isCorrect = false;

    //         if ((englishWord.equals("Hello") && spanishWord.equals("Hola")) ||
    //             (englishWord.equals("Goodbye") && spanishWord.equals("Adiós")) ||
    //             (englishWord.equals("Thank you") && spanishWord.equals("Gracias")) ||
    //             (englishWord.equals("Please") && spanishWord.equals("Por favor"))) {
    //             feedbackLabel.setText("Correct Match!");
    //             feedbackLabel.setStyle("-fx-text-fill: green;");
    //             isCorrect = true;
    //         } else {
    //             feedbackLabel.setText("Incorrect Match! Try Again.");
    //             feedbackLabel.setStyle("-fx-text-fill: red;");
    //         }
    //         feedbackLabel.setVisible(true);
    //         onQuestionAnswered(isCorrect);
    //     } else {
    //         feedbackLabel.setText("Please select both words before submitting.");
    //         feedbackLabel.setStyle("-fx-text-fill: orange;");
    //         feedbackLabel.setVisible(true);
    //     }
    // }

    private void handleSubmit(ActionEvent event) {
        if (selectedEnglishButton != null && selectedSpanishButton != null) {  // or whatever your correct answer check is
            String englishWord = selectedEnglishButton.getText();
            String spanishWord = selectedSpanishButton.getText();
        
            if ((englishWord.equals("Hello") && spanishWord.equals("Hola")) ||
                (englishWord.equals("Goodbye") && spanishWord.equals("Adiós")) ||
                (englishWord.equals("Thank you") && spanishWord.equals("Gracias")) ||
                (englishWord.equals("Please") && spanishWord.equals("Por favor"))) {
                
                feedbackLabel.setText("Correct Match!");
                feedbackLabel.setStyle("-fx-text-fill: green;");
                feedbackLabel.setVisible(true);
                
                // Add delay then go to next question
                new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            javafx.application.Platform.runLater(() -> {
                                try {
                                    // Go to next question
                                    App.setRoot("trueFalse");  // or whatever your next question screen is
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
                        }
                    },
                    2000 // 2 second delay
                );
            } else {
                feedbackLabel.setText("Incorrect Match! Try Again.");
                feedbackLabel.setStyle("-fx-text-fill: red;");
                feedbackLabel.setVisible(true);
            }
        }
    }
    // // Navigation handlers
    // @FXML
    // private void handleHome(ActionEvent event) {
    //     System.out.println("Navigating to Home");
    // }

    // @FXML
    // private void handleRanking(ActionEvent event) {
    //     System.out.println("Navigating to Ranking");
    // }

    // @FXML
    // private void handleFlashcards(ActionEvent event) {
    //     System.out.println("Navigating to Flashcards");
    // }

    // @FXML
    // private void handleProfile(ActionEvent event) {
    //     System.out.println("Navigating to Profile");
    // }

    @FXML
    public void initialize() {
        feedbackLabel.setText("");
        feedbackLabel.setVisible(false);
    }

    private QuestionCompletionCallback callback;

    @Override
    public void setCompletionCallback(QuestionCompletionCallback callback) {
        this.callback = callback;
    }

    private void onQuestionAnswered(boolean isCorrect) {
        
        System.out.println("VocabController: Question answered with result: " + isCorrect);
    if (callback != null) {
        System.out.println("VocabController: Calling completion callback");
        callback.onComplete(isCorrect);
    } else {
        System.out.println("VocabController: Callback is null!");
    }
    }

    @FXML void loadLessonFlashcards(ActionEvent event) throws IOException {
        App.setRoot("lesson1flash");
    }

    @FXML void handleFlashcards(MouseEvent event) throws IOException {
        App.setRoot("flashcard");
    }

    @FXML void handleHome(MouseEvent event) throws IOException {
        App.setRoot("home");
    }

    @FXML void handleProfile(MouseEvent event) throws IOException {
        App.setRoot("profile");
    }

    @FXML void handleRanking(MouseEvent event) throws IOException {
        App.setRoot("ranking");
    }
}

