package com.controllers;

import java.io.IOException;

import com.language.App;
import com.model.CockySpeak;
import com.model.Language;
import com.model.Lesson;
import com.model.ProgressTracker;
import com.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.control.Label;

public class FlashcardMenuController {

    @FXML
    private Button lesson1Flashcards;


    @FXML
    void loadLessonFlashcards(ActionEvent event) throws IOException {
        App.setRoot("lesson1flash");
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
    void handleProfile(MouseEvent event) throws IOException{
        App.setRoot("profile");
    }

    @FXML
    void handleRanking(MouseEvent event) throws IOException {
        App.setRoot("ranking");
    }

    @FXML
    void starbuttonclick(MouseEvent event) throws IOException {
        // App.setRoot("flashcard");
                testLessonProgress();
    }

    @FXML
    void handlebutton(MouseEvent event) {

    }

     @FXML
    private Label startbutton;
    
    // Add references to your circle buttons
    @FXML
    private Ellipse lesson1Circle;
    @FXML
    private Ellipse lesson2Circle;
    @FXML
    private Ellipse lesson3Circle;
    @FXML
    private Ellipse lesson4Circle;
    @FXML
    private Ellipse lesson5Circle;

    private CockySpeak cockySpeak = new CockySpeak();
    private ProgressTracker progressTracker;

    @FXML
    public void initialize() {
        // Get the current user's progress tracker
        if (cockySpeak.getCurrentUser() != null) {
            Language spanish = new Language("Spanish");
            progressTracker = cockySpeak.getCurrentUser().getLanguageProgressTracker(spanish);
            updateCircleColors();
        }
    }

    // @FXML
    // void starbuttonclick(MouseEvent event) {
    //     // Get the clicked circle's number from the source ID
    //     String sourceId = ((Circle) event.getSource()).getId();
    //     int lessonNumber = extractLessonNumber(sourceId);
        
    //     if (canStartLesson(lessonNumber)) {
    //         startLesson("Module " + lessonNumber);
    //     }
    // }

    private boolean canStartLesson(int lessonNumber) {
        // First lesson is always available
        if (lessonNumber == 1) return true;
        
        // Other lessons require previous lesson to be completed
        return progressTracker != null && 
               progressTracker.getCompletedLessons() >= (lessonNumber - 1);
    }

    private void startLesson(String moduleName) {
        Lesson lesson = new Lesson(moduleName, new Language("Spanish"));
        int score = lesson.playLesson();

        if (score >= 80) {
            // Update progress tracker
            progressTracker.completeLesson();
            
            // Update UI
            updateCircleColors();
            
            // Show success message or transition to next screen
            System.out.println("Lesson completed successfully!");
        } else {
            System.out.println("Please try the lesson again.");
        }
    }

    private void updateCircleColors() {
        int completedLessons = progressTracker.getCompletedLessons();
        
        Ellipse[] ellipse = {lesson1Circle, lesson2Circle, lesson3Circle, lesson4Circle, lesson5Circle};
        
        for (int i = 0; i < ellipse.length; i++) {
            if (ellipse[i] != null) {
                ellipse[i].getStyleClass().removeAll(
                    "lesson-circle-locked", 
                    "lesson-circle-available", 
                    "lesson-circle-completed"
                );
                
                if (i < completedLessons) {
                    ellipse[i].getStyleClass().add("lesson-circle-completed");
                } else if (i == completedLessons) {
                    ellipse[i].getStyleClass().add("lesson-circle-available");
                } else {
                    ellipse[i].getStyleClass().add("lesson-circle-locked");
                }
            }
        }
    }

    private int extractLessonNumber(String sourceId) {
        // Extract the lesson number from the circle's ID
        // Assuming IDs are in format "lesson1Circle", "lesson2Circle", etc.
        return Integer.parseInt(sourceId.replaceAll("\\D+", ""));
    }



    @FXML
void testLessonProgress() {
    // Simulate completing a lesson
    if (progressTracker == null) {
        // Create a new progress tracker if none exists
        Language spanish = new Language("Spanish");
        User currentUser = cockySpeak.getCurrentUser();
        if (currentUser == null) {
            // Create a test user if none exists
            cockySpeak.register("TestUser", "test", "test@test.com");
            cockySpeak.login("TestUser", "test");
            cockySpeak.setLanguage(spanish);
            currentUser = cockySpeak.getCurrentUser();
        }
        progressTracker = currentUser.getLanguageProgressTracker(spanish);
    }
    
    // Complete a lesson
    progressTracker.completeLesson();
    
    // Update the UI
    updateCircleColors();
    
    System.out.println("Completed lessons: " + progressTracker.getCompletedLessons());
}



}


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

// public class FlashcardMenuController {
//     @FXML private ImageView flagImageView;
//     @FXML private Ellipse startbutton;
//     @FXML private Ellipse lesson1Circle;
//     @FXML private Ellipse lesson2Circle;
//     @FXML private Ellipse lesson3Circle;
//     @FXML private Ellipse lesson4Circle;
//     @FXML private Ellipse lesson5Circle;
//     @FXML private Label startbuttonLabel;
    
//     private CockySpeak cockySpeak = new CockySpeak();
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

//     @FXML 
//     void starbutton() {
//         navigateToScreen("/fxml/VocabMatching.fxml");
//     }

//     @FXML
//     void starbuttonclick(MouseEvent event) {
//         Object source = event.getSource();
//         if (source instanceof Ellipse) {
//             Ellipse clickedEllipse = (Ellipse) source;
//             String ellipseId = clickedEllipse.getId();
//             int lessonNumber = extractLessonNumber(ellipseId);
            
//             if (canStartLesson(lessonNumber)) {
//                 navigateToScreen("/fxml/VocabMatching.fxml");
//             }
//         }
//     }

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
//         Ellipse[] circles = {lesson1Circle, lesson2Circle, lesson3Circle, lesson4Circle, lesson5Circle};
        
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

//     @FXML private void handleHome() { navigateToScreen("/fxml/Home.fxml"); }
//     @FXML private void handleRanking() { navigateToScreen("/fxml/Ranking.fxml"); }
//     @FXML private void handleFlashcards() { navigateToScreen("/fxml/Flashcards.fxml"); }
//     @FXML private void handleProfile() { navigateToScreen("/fxml/Profile.fxml"); }
// }
