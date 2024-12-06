// package com.controllers;

// import java.io.IOException;

// import com.language.App;
// import com.model.CockySpeak;
// import com.model.Language;
// import com.model.Lesson;
// import com.model.ProgressTracker;
// import com.model.User;

// import javafx.event.ActionEvent;
// import javafx.fxml.FXML;
// import javafx.scene.control.Button;
// import javafx.scene.input.MouseEvent;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Circle;
// import javafx.scene.shape.Ellipse;
// import javafx.scene.control.Label;

// public class FlashcardMenuController {

    // @FXML
    // private Button lesson1Flashcards;


    // @FXML
    // void loadLessonFlashcards(ActionEvent event) throws IOException {
    //     App.setRoot("lesson1flash");
    // }

    // @FXML
    // void handleFlashcards(MouseEvent event) throws IOException {
    //     App.setRoot("flashcard");
    // }

    // @FXML
    // void handleHome(MouseEvent event) throws IOException {
    //     App.setRoot("home");
    // }

    // @FXML
    // void handleProfile(MouseEvent event) throws IOException{
    //     App.setRoot("profile");
    // }

    // @FXML
    // void handleRanking(MouseEvent event) throws IOException {
    //     App.setRoot("ranking");
    // }

//     @FXML
//     void starbuttonclick(MouseEvent event) throws IOException {
//         // App.setRoot("flashcard");
//                 testLessonProgress();
//     }

//     @FXML
//     void handlebutton(MouseEvent event) {

//     }

//      @FXML
//     private Label startbutton;
    
//     // Add references to your circle buttons
//     @FXML
//     private Ellipse lesson1Circle;
//     @FXML
//     private Ellipse lesson2Circle;
//     @FXML
//     private Ellipse lesson3Circle;
//     @FXML
//     private Ellipse lesson4Circle;
//     @FXML
//     private Ellipse lesson5Circle;

//     private CockySpeak cockySpeak = CockySpeak.getInstance();
//     private ProgressTracker progressTracker;

//     @FXML
//     public void initialize() {
//         // Get the current user's progress tracker
//         if (cockySpeak.getCurrentUser() != null) {
//             Language spanish = new Language("Spanish");
//             progressTracker = cockySpeak.getCurrentUser().getLanguageProgressTracker(spanish);
//             updateCircleColors();
//         }
//     }

//     // @FXML
//     // void starbuttonclick(MouseEvent event) {
//     //     // Get the clicked circle's number from the source ID
//     //     String sourceId = ((Circle) event.getSource()).getId();
//     //     int lessonNumber = extractLessonNumber(sourceId);
        
//     //     if (canStartLesson(lessonNumber)) {
//     //         startLesson("Module " + lessonNumber);
//     //     }
//     // }

//     private boolean canStartLesson(int lessonNumber) {
//         // First lesson is always available
//         if (lessonNumber == 1) return true;
        
//         // Other lessons require previous lesson to be completed
//         return progressTracker != null && 
//                progressTracker.getCompletedLessons() >= (lessonNumber - 1);
//     }

//     private void startLesson(String moduleName) {
//         Lesson lesson = new Lesson(moduleName, new Language("Spanish"));
//         int score = lesson.playLesson();

//         if (score >= 80) {
//             // Update progress tracker
//             progressTracker.completeLesson();
            
//             // Update UI
//             updateCircleColors();
            
//             // Show success message or transition to next screen
//             System.out.println("Lesson completed successfully!");
//         } else {
//             System.out.println("Please try the lesson again.");
//         }
//     }

//     private void updateCircleColors() {
//         int completedLessons = progressTracker.getCompletedLessons();
        
//         Ellipse[] ellipse = {lesson1Circle, lesson2Circle, lesson3Circle, lesson4Circle, lesson5Circle};
        
//         for (int i = 0; i < ellipse.length; i++) {
//             if (ellipse[i] != null) {
//                 ellipse[i].getStyleClass().removeAll(
//                     "lesson-circle-locked", 
//                     "lesson-circle-available", 
//                     "lesson-circle-completed"
//                 );
                
//                 if (i < completedLessons) {
//                     ellipse[i].getStyleClass().add("lesson-circle-completed");
//                 } else if (i == completedLessons) {
//                     ellipse[i].getStyleClass().add("lesson-circle-available");
//                 } else {
//                     ellipse[i].getStyleClass().add("lesson-circle-locked");
//                 }
//             }
//         }
//     }

//     private int extractLessonNumber(String sourceId) {
//         // Extract the lesson number from the circle's ID
//         // Assuming IDs are in format "lesson1Circle", "lesson2Circle", etc.
//         return Integer.parseInt(sourceId.replaceAll("\\D+", ""));
//     }



//     @FXML
// void testLessonProgress() {
//     // Simulate completing a lesson
//     if (progressTracker == null) {
//         // Create a new progress tracker if none exists
//         Language spanish = new Language("Spanish");
//         User currentUser = cockySpeak.getCurrentUser();
//         if (currentUser == null) {
//             // Create a test user if none exists
//             cockySpeak.register("TestUser", "test", "test@test.com");
//             cockySpeak.login("TestUser", "test");
//             cockySpeak.setLanguage(spanish);
//             currentUser = cockySpeak.getCurrentUser();
//         }
//         progressTracker = currentUser.getLanguageProgressTracker(spanish);
//     }
    
//     // Complete a lesson
//     progressTracker.completeLesson();
    
//     // Update the UI
//     updateCircleColors();
    
//     System.out.println("Completed lessons: " + progressTracker.getCompletedLessons());
// }



//}







//Second version below of code



// package com.controllers;

// import java.io.IOException;
// import javafx.fxml.FXML;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.image.ImageView;
// import javafx.scene.input.MouseEvent;
// import javafx.scene.paint.Color;
// import javafx.scene.shape.Rectangle;
// import javafx.scene.shape.Ellipse;
// import javafx.scene.control.Label;
// import javafx.stage.Stage;
// import com.model.CockySpeak;
// import com.model.Language;
// import com.model.ProgressTracker;
// import com.model.User;
// import javafx.event.ActionEvent;
// import com.language.App;

// public class FlashcardMenuController {
//     @FXML private ImageView flagImageView;
//     @FXML private Label startbutton;
//     @FXML private Ellipse lesson1Circle;
//     @FXML private Ellipse lesson2Circle;
//     @FXML private Ellipse lesson3Circle;
//     @FXML private Ellipse lesson4Circle;
//     @FXML private Ellipse lesson5Circle;
//     @FXML private Ellipse lesson6Circle;
//     @FXML private Label startbuttonLabel;
    


//     @FXML
//     private Button lesson1Flashcards;


//     @FXML
//     void loadLessonFlashcards(ActionEvent event) throws IOException {
//         App.setRoot("lesson1flash");
//     }

//     @FXML
//     void handleFlashcards(MouseEvent event) throws IOException {
//         App.setRoot("flashcard");
//     }

//     @FXML
//     void handleHome(MouseEvent event) throws IOException {
//         App.setRoot("home");
//     }

//     @FXML
//     void handleProfile(MouseEvent event) throws IOException{
//         App.setRoot("profile");
//     }

//     @FXML
//     void handleRanking(MouseEvent event) throws IOException {
//         App.setRoot("ranking");
//     }
    
//     private CockySpeak cockySpeak = CockySpeak.getInstance();
//     private ProgressTracker progressTracker;
//     private Language spanish = new Language("Spanish");
//     private static boolean level1Completed = false;

//     @FXML
//     public void initialize() {
//         setupFlagImage();
//         initializeProgressTracker();
//         updateCircleColors();
//     }
    
//     private void setupFlagImage() {
//         if (flagImageView != null) {
//             Rectangle clip = new Rectangle(
//                 flagImageView.getFitWidth(), 
//                 flagImageView.getFitHeight()
//             );
//             clip.setArcWidth(30);
//             clip.setArcHeight(30);
//             clip.setStroke(Color.TRANSPARENT);
//             flagImageView.setClip(clip);
//         }
//     }
    
//     private void initializeProgressTracker() {
//         if (cockySpeak.getCurrentUser() != null) {
//             progressTracker = cockySpeak.getCurrentUser().getLanguageProgressTracker(spanish);
//             if (progressTracker == null) {
//                 User currentUser = cockySpeak.getCurrentUser();
//                 currentUser.createLanguageProgress(spanish);
//                 progressTracker = currentUser.getLanguageProgressTracker(spanish);
//             }
//         }
//     }

//     // @FXML 
//     // void starbutton() {
//     //     navigateToScreen("/fxml/VocabMatching.fxml");
//     // }

//     // @FXML
//     // void starbuttonclick(MouseEvent event) {
//     //     Object source = event.getSource();
//     //     if (source instanceof Ellipse) {
//     //         Ellipse clickedEllipse = (Ellipse) source;
//     //         String ellipseId = clickedEllipse.getId();
//     //         int lessonNumber = extractLessonNumber(ellipseId);
            
//     //         if (canStartLesson(lessonNumber)) {
//     //             navigateToScreen("/fxml/VocabMatching.fxml");
//     //         }
//     //     }
//     // }

//     private boolean canStartLesson(int lessonNumber) {
//         if (lessonNumber == 1) return true;
//         return progressTracker != null && 
//                progressTracker.getCompletedLessons() >= (lessonNumber - 1);
//     }

//     private int extractLessonNumber(String ellipseId) {
//         return Integer.parseInt(ellipseId.replaceAll("\\D+", ""));
//     }

//     private void updateCircleColors() {
//         if (progressTracker == null) return;
        
//         int completedLessons = progressTracker.getCompletedLessons();
//         Ellipse[] circles = {lesson1Circle, lesson2Circle, lesson3Circle, lesson4Circle, lesson5Circle, lesson6Circle};
        
//         for (int i = 0; i < circles.length; i++) {
//             if (circles[i] != null) {
//                 circles[i].getStyleClass().removeAll(
//                     "lesson-circle-locked", 
//                     "lesson-circle-available", 
//                     "lesson-circle-completed"
//                 );
                
//                 if (i < completedLessons) {
//                     circles[i].getStyleClass().add("lesson-circle-completed");
//                 } else if (i == completedLessons) {
//                     circles[i].getStyleClass().add("lesson-circle-available");
//                 } else {
//                     circles[i].getStyleClass().add("lesson-circle-locked");
//                 }
//             }
//         }
//     }

//     public void onLessonComplete() {
//         if (progressTracker != null) {
//             progressTracker.completeLesson();
//             level1Completed = true;
//             updateCircleColors();
//             navigateToScreen("/fxml/flashcard");
//         }
//     }
    
//     private void navigateToScreen(String fxmlPath) {
//         try {
//             FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
//             Scene scene = new Scene(loader.load());
//             Stage stage = (Stage) startbutton.getScene().getWindow();
//             scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
//             stage.setScene(scene);
//         } catch (IOException e) {
//             System.err.println("Navigation failed: " + e.getMessage());
//             e.printStackTrace();
//         }
//     }

//     @FXML
// private void testLessonProgress(MouseEvent event) {
//     // Initialize a test user and progress if needed
//     if (progressTracker == null) {
//         System.out.println("Initializing test progress tracker...");
//         Language spanish = new Language("Spanish");
//         User currentUser = cockySpeak.getCurrentUser();
        
//         if (currentUser == null) {
//             System.out.println("Creating test user...");
//             cockySpeak.register("TestUser", "test", "test@test.com");
//             cockySpeak.login("TestUser", "test");
//             currentUser = cockySpeak.getCurrentUser();
//         }
        
//         System.out.println("Setting up Spanish language...");
//         cockySpeak.setLanguage(spanish);
//         progressTracker = currentUser.getLanguageProgressTracker(spanish);
//     }
    
//     // Complete current lesson
//     System.out.println("Current lesson progress: " + progressTracker.getCompletedLessons());
//     progressTracker.completeLesson();
//     System.out.println("After completion: " + progressTracker.getCompletedLessons());
    
//     // Update UI to show progress
//     updateCircleColors();
    
//     // For testing: Print the state of each circle
//     Ellipse[] circles = {lesson1Circle, lesson2Circle, lesson3Circle, lesson4Circle, lesson5Circle};
//     for (int i = 0; i < circles.length; i++) {
//         if (circles[i] != null) {
//             System.out.println("Circle " + (i+1) + " style classes: " + 
//                 circles[i].getStyleClass().toString());
//         }
//     }

    
//     // Simulate navigation when ready (commented out until screens are ready)
//     /*
//     try {
//         navigateToScreen("/fxml/VocabMatching.fxml");
//     } catch (Exception e) {
//         System.out.println("Navigation not yet implemented: " + e.getMessage());
//         // For now, just update the visual feedback
//         updateCircleColors();
//     }
//     */
// }

//     // @FXML private void handleHome() { navigateToScreen("/fxml/Home.fxml"); }
//     // @FXML private void handleRanking() { navigateToScreen("/fxml/Ranking.fxml"); }
//     // @FXML private void handleFlashcards() { navigateToScreen("/fxml/Flashcards.fxml"); }
//     // @FXML private void handleProfile() { navigateToScreen("/fxml/Profile.fxml"); }


//     @FXML
//     private void startLesson(MouseEvent event) {
//         if (event.getSource() instanceof Ellipse) {
//             Ellipse clickedEllipse = (Ellipse) event.getSource();
//             String ellipseId = clickedEllipse.getId();
//             int lessonNumber = extractLessonNumber(ellipseId);
            
//             if (canStartLesson(lessonNumber)) {
//                 startRandomizedQuestions();
//             }
//         }
//     }

//     private class CompletionCallback implements QuestionCompletionCallback {
//         @Override
//         public void onComplete(boolean isCorrect) {
//             onQuestionComplete(isCorrect);
//         }
//     }

//     private void startRandomizedQuestions() {
//         try {
//             String[] questionTypes = {"/fxml/VocabMatching.fxml", "/fxml/TrueFalse.fxml", "/fxml/MultipleChoice.fxml"};
//             int randomIndex = (int) (Math.random() * questionTypes.length);
//             String randomQuestion = questionTypes[randomIndex];
            
//             FXMLLoader loader = new FXMLLoader(getClass().getResource(randomQuestion));
//             Scene scene = new Scene(loader.load());
//             Stage stage = (Stage) startbutton.getScene().getWindow();
//             scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
            
//             // Get controller and set completion callback
//             Object controller = loader.getController();
//             if (controller instanceof VocabController) {
//                 ((VocabController) controller).setCompletionCallback(this::onQuestionComplete);
//             } else if (controller instanceof TrueFalseController) {
//                 ((TrueFalseController) controller).setCompletionCallback(this::onQuestionComplete);
//             } else if (controller instanceof MultipleChoiceController) {
//                 ((MultipleChoiceController) controller).setCompletionCallback(this::onQuestionComplete);
//             }
            
//             stage.setScene(scene);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private void onQuestionComplete(boolean isCorrect) {
//         if (isCorrect) {
//             questionCount++;
//             if (questionCount >= QUESTIONS_TO_COMPLETE) {
//                 progressTracker.completeLesson();
//                 updateCircleColors();
//                 navigateToScreen("/fxml/flashcard");
//             } else {
//                 startRandomizedQuestions();
//             }
//         }
//     }

//     private static final int QUESTIONS_TO_COMPLETE = 3;
//     private int questionCount = 0;
// }

package com.controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Ellipse;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.model.CockySpeak;
import com.model.Language;
import com.model.ProgressTracker;
import com.model.User;
import javafx.event.ActionEvent;
import com.language.App;
import com.controllers.VocabController;
import com.controllers.TrueFalseController;
import com.controllers.MultipleChoiceController;
import com.controllers.QuestionController;
import com.controllers.QuestionCompletionCallback;

public class FlashcardMenuController {
    @FXML private ImageView flagImageView;
    @FXML private Label startbutton;
    @FXML private Ellipse lesson1Circle;
    @FXML private Ellipse lesson2Circle;
    @FXML private Ellipse lesson3Circle;
    @FXML private Ellipse lesson4Circle;
    @FXML private Ellipse lesson5Circle;
    @FXML private Ellipse lesson6Circle;
    @FXML private Label startbuttonLabel;
    @FXML private Button lesson1Flashcards;

    private CockySpeak cockySpeak = CockySpeak.getInstance();
    private ProgressTracker progressTracker;
    private Language spanish = new Language("Spanish");
    private static final int QUESTIONS_TO_COMPLETE = 3;
    private int questionCount = 0;

    private class CompletionCallback implements QuestionCompletionCallback {
        @Override
        public void onComplete(boolean isCorrect) {
            FlashcardMenuController.this.onQuestionComplete(isCorrect);
        }
    }
    
    // private void onQuestionComplete(boolean isCorrect) {
    //     if (isCorrect) {
    //         questionCount++;
    //         if (questionCount >= QUESTIONS_TO_COMPLETE) {
    //             progressTracker.completeLesson();
    //             updateCircleColors();
    //             navigateToScreen("/fxml/flashcard");
    //         } else {
    //             startSpecificQuestion(questionCount + 1);  // Changed from startRandomizedQuestions()
    //         }
    //     }
    // }

    private void onQuestionComplete(boolean isCorrect) {
        if (isCorrect) {
            questionCount++;
            System.out.println("Question " + questionCount + " completed successfully");
            
            updateSpecificCircle(questionCount, true);
            
            if (questionCount >= QUESTIONS_TO_COMPLETE) {
                // All questions completed
                progressTracker.completeLesson();
                updateCircleColors();
                
                // Navigate to home after a delay
                try {
                    App.setRoot("home");  // You can remove this if you don't want to go home at all
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // Instead of going home, directly go to next question type
                try {
                    String nextScreen;
                    switch(questionCount) {
                        case 1:
                            nextScreen = "trueFalse";
                            break;
                        case 2:
                            nextScreen = "multipleChoice";
                            break;
                        default:
                            nextScreen = "home";
                            break;
                    }
                    App.setRoot(nextScreen);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    // Update startSpecificQuestion in FlashcardMenuController:
    private void startSpecificQuestion(int questionNumber) {
        try {
            String questionPath;
            switch(questionNumber) {
                case 1:
                    questionPath = "vocabMatching";
                    break;
                case 2:
                    questionPath = "trueFalse";
                    break;
                case 3:
                    questionPath = "multipleChoice";
                    break;
                default:
                    System.out.println("Invalid question number: " + questionNumber);
                    return;
            }
            
            System.out.println("Loading question " + questionNumber + ": " + questionPath);
            
            // Use the modified setRoot method that returns the FXMLLoader
            FXMLLoader loader = App.setRoot(questionPath);
            
            // Get the controller and set the callback
            QuestionController controller = loader.getController();
            if (controller != null) {
                System.out.println("Controller type: " + controller.getClass().getName());
                System.out.println("Setting callback for question " + questionNumber);
                controller.setCompletionCallback(new CompletionCallback());
            } else {
                System.err.println("Failed to get controller for " + questionPath);
            }
            
        } catch (IOException e) {
            System.err.println("Failed to load question screen: " + e.getMessage());
            e.printStackTrace();
        }
    }
    // New method to update specific circle
    private void updateSpecificCircle(int questionNumber, boolean completed) {
        Ellipse[] circles = {lesson1Circle, lesson2Circle, lesson3Circle, lesson4Circle, lesson5Circle, lesson6Circle};
        if (questionNumber > 0 && questionNumber <= circles.length && circles[questionNumber - 1] != null) {
            circles[questionNumber - 1].getStyleClass().removeAll(
                "lesson-circle-locked", 
                "lesson-circle-available", 
                "lesson-circle-completed"
            );
            
            if (completed) {
                circles[questionNumber - 1].getStyleClass().add("lesson-circle-completed");
                if (questionNumber < circles.length) {
                    // Make next circle available
                    circles[questionNumber].getStyleClass().removeAll(
                        "lesson-circle-locked", 
                        "lesson-circle-available", 
                        "lesson-circle-completed"
                    );
                    circles[questionNumber].getStyleClass().add("lesson-circle-available");
                }
            }
        }
    }
    
    // // Modified startSpecificQuestion method
    // private void startSpecificQuestion(int questionNumber) {
    //     try {
    //         String questionPath;
    //         switch(questionNumber) {
    //             case 1:
    //                 questionPath = "vocabMatching.fxml";
    //                 break;
    //             case 2:
    //                 questionPath = "trueFalse.fxml";
    //                 break;
    //             case 3:
    //                 questionPath = "multipleChoice.fxml";
    //                 break;
    //             default:
    //                 System.out.println("Invalid question number: " + questionNumber);
    //                 return;
    //         }
            
    //         System.out.println("Loading question " + questionNumber + ": " + questionPath);
    //         FXMLLoader loader = new FXMLLoader(getClass().getResource(questionPath));
    //         Scene scene = new Scene(loader.load());
    //         Stage stage = (Stage) startbutton.getScene().getWindow();
    //         scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
            
    //         Object controller = loader.getController();
    //         CompletionCallback callback = new CompletionCallback();
            
    //         if (controller instanceof QuestionController) {
    //             ((QuestionController) controller).setCompletionCallback(callback);
    //             System.out.println("Callback set for question " + questionNumber);
    //         }
            
    //         stage.setScene(scene);
    //     } catch (IOException e) {
    //         System.err.println("Failed to load question screen: " + e.getMessage());
    //         e.printStackTrace();
    //     }
    // }
    

    @FXML
private void startLesson(MouseEvent event) {
    if (event.getSource() instanceof Ellipse) {
        Ellipse clickedEllipse = (Ellipse) event.getSource();
        String ellipseId = clickedEllipse.getId();
        int lessonNumber = extractLessonNumber(ellipseId);
        
        System.out.println("Attempting to start lesson " + lessonNumber);
        System.out.println("Progress tracker is " + (progressTracker == null ? "null" : "not null"));
        System.out.println("Current user is " + (cockySpeak.getCurrentUser() == null ? "null" : "not null"));
        
        if (progressTracker != null && canStartLesson(lessonNumber)) {
            questionCount = 0;
            // Instead of random, use specific lesson type based on number
            startSpecificQuestion(lessonNumber);
        } else {
            System.out.println("Cannot start lesson: Progress tracker is null or lesson cannot be started.");
        }
    }
}

// private void startSpecificQuestion(int lessonNumber) {
//     try {
//         String questionPath;
//         switch(lessonNumber) {
//             case 1:
//                 questionPath = "vocabMatching.fxml";
//                 break;
//             case 2:
//                 questionPath = "trueFalse.fxml";
//                 break;
//             case 3:
//                 questionPath = "multipleChoice.fxml";
//                 break;
//             default:
//                 System.out.println("Invalid lesson number");
//                 return;
//         }
        
//         FXMLLoader loader = new FXMLLoader(getClass().getResource(questionPath));
//         Scene scene = new Scene(loader.load());
//         Stage stage = (Stage) startbutton.getScene().getWindow();
//         scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
        
//         Object controller = loader.getController();
//         CompletionCallback callback = new CompletionCallback();
        
//         if (controller instanceof VocabController) {
//             ((VocabController) controller).setCompletionCallback(callback);
//         } else if (controller instanceof TrueFalseController) {
//             ((TrueFalseController) controller).setCompletionCallback(callback);
//         } else if (controller instanceof MultipleChoiceController) {
//             ((MultipleChoiceController) controller).setCompletionCallback(callback);
//         }
        
//         stage.setScene(scene);
//     } catch (IOException e) {
//         System.err.println("Failed to load question screen: " + e.getMessage());
//         e.printStackTrace();
//     }
// }

@FXML
private void handleVocabMatching(MouseEvent event) throws IOException {
    App.setRoot("vocabMatching");
}

    @FXML
    public void initialize() {
        try {
            User currentUser = cockySpeak.getCurrentUser();
            if (currentUser == null) {
                System.err.println("No current user found - creating test user");
                cockySpeak.register("TestUser", "test", "test@test.com");
                cockySpeak.login("TestUser", "test");
                currentUser = cockySpeak.getCurrentUser();
            }
    
            if (currentUser != null) {
                progressTracker = currentUser.getLanguageProgressTracker(spanish);
                if (progressTracker == null) {
                    System.out.println("Creating new progress tracker for Spanish");
                    currentUser.createLanguageProgress(spanish);
                    progressTracker = currentUser.getLanguageProgressTracker(spanish);
                }
                updateCircleColors();
            } else {
                System.err.println("Failed to create or get current user");
            }
        } catch (Exception e) {
            System.err.println("Error during initialization: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    private void setupFlagImage() {
        if (flagImageView != null) {
            Rectangle clip = new Rectangle(
                flagImageView.getFitWidth(), 
                flagImageView.getFitHeight()
            );
            clip.setArcWidth(30);
            clip.setArcHeight(30);
            clip.setStroke(Color.TRANSPARENT);
            flagImageView.setClip(clip);
        }
    }
    
    private void initializeProgressTracker() {
        if (cockySpeak.getCurrentUser() != null) {
            progressTracker = cockySpeak.getCurrentUser().getLanguageProgressTracker(spanish);
            if (progressTracker == null) {
                User currentUser = cockySpeak.getCurrentUser();
                currentUser.createLanguageProgress(spanish);
                progressTracker = currentUser.getLanguageProgressTracker(spanish);
            }
        }
    }

    // @FXML
    // private void startLesson(MouseEvent event) {
    //     if (event.getSource() instanceof Ellipse) {
    //         Ellipse clickedEllipse = (Ellipse) event.getSource();
    //         String ellipseId = clickedEllipse.getId();
    //         int lessonNumber = extractLessonNumber(ellipseId);
            
    //         System.out.println("Attempting to start lesson " + lessonNumber);
    //         System.out.println("Progress tracker is " + (progressTracker == null ? "null" : "not null"));
    //         System.out.println("Current user is " + (cockySpeak.getCurrentUser() == null ? "null" : "not null"));
            
    //         if (progressTracker != null && canStartLesson(lessonNumber)) {
    //             questionCount = 0;
    //             startRandomizedQuestions();
    //         } else {
    //             System.out.println("Cannot start lesson: Progress tracker is null or lesson cannot be started.");
    //         }
    //     }
    // }

    private boolean canStartLesson(int lessonNumber) {
        if (lessonNumber == 1) return true;
        return progressTracker != null && 
               progressTracker.getCompletedLessons() >= (lessonNumber - 1);
    }

    // private void startRandomizedQuestions() {
    //     try {
    //         String[] questionTypes = {"/fxml/vocabMatching.fxml", "/fxml/trueFalse.fxml", "/fxml/multipleChoice.fxml"};
    //         int randomIndex = (int) (Math.random() * questionTypes.length);
    //         String randomQuestion = questionTypes[randomIndex];
            
    //         FXMLLoader loader = new FXMLLoader(getClass().getResource(randomQuestion));
    //         Scene scene = new Scene(loader.load());
    //         Stage stage = (Stage) startbutton.getScene().getWindow();
    //         scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
            
    //         Object controller = loader.getController();
    //         CompletionCallback callback = new CompletionCallback();
            
    //         if (controller instanceof VocabController) {
    //             ((VocabController) controller).setCompletionCallback(callback);
    //         } else if (controller instanceof TrueFalseController) {
    //             ((TrueFalseController) controller).setCompletionCallback(callback);
    //         } else if (controller instanceof MultipleChoiceController) {
    //             ((MultipleChoiceController) controller).setCompletionCallback(callback);
    //         }
            
    //         stage.setScene(scene);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    // private void onQuestionComplete(boolean isCorrect) {
    //     if (isCorrect) {
    //         questionCount++;
    //         if (questionCount >= QUESTIONS_TO_COMPLETE) {
    //             progressTracker.completeLesson();
    //             updateCircleColors();
    //             navigateToScreen("/fxml/flashcard");
    //         } else {
    //             startRandomizedQuestions();
    //         }
    //     }
    // }

    private void updateCircleColors() {
        if (progressTracker == null) return;
        
        int completedLessons = progressTracker.getCompletedLessons();
        Ellipse[] circles = {lesson1Circle, lesson2Circle, lesson3Circle, lesson4Circle, lesson5Circle, lesson6Circle};
        
        for (int i = 0; i < circles.length; i++) {
            if (circles[i] != null) {
                circles[i].getStyleClass().removeAll(
                    "lesson-circle-locked", 
                    "lesson-circle-available", 
                    "lesson-circle-completed"
                );
                
                if (i < completedLessons) {
                    circles[i].getStyleClass().add("lesson-circle-completed");
                } else if (i == completedLessons) {
                    circles[i].getStyleClass().add("lesson-circle-available");
                } else {
                    circles[i].getStyleClass().add("lesson-circle-locked");
                }
            }
        }
    }

    private int extractLessonNumber(String ellipseId) {
        return Integer.parseInt(ellipseId.replaceAll("\\D+", ""));
    }

    private void navigateToScreen(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) startbutton.getScene().getWindow();
            scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
            stage.setScene(scene);
        } catch (IOException e) {
            System.err.println("Navigation failed: " + e.getMessage());
            e.printStackTrace();
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

    //ranking
    //vocabMatching
}


