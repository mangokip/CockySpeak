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
        App.setRoot("flashcard");
    }

    @FXML
    void handlebutton(MouseEvent event) {

    }

     @FXML
    private Label startbutton;
    
    // // Add references to your circle buttons
    // @FXML
    // private Circle lesson1Circle;
    // @FXML
    // private Circle lesson2Circle;
    // @FXML
    // private Circle lesson3Circle;
    // @FXML
    // private Circle lesson4Circle;
    // @FXML
    // private Circle lesson5Circle;

    // private CockySpeak cockySpeak = new CockySpeak();
    // private ProgressTracker progressTracker;

    // @FXML
    // public void initialize() {
    //     // Get the current user's progress tracker
    //     if (cockySpeak.getCurrentUser() != null) {
    //         Language spanish = new Language("Spanish");
    //         progressTracker = cockySpeak.getCurrentUser().getLanguageProgressTracker(spanish);
    //         updateCircleColors();
    //     }
    // }

    // @FXML
    // void starbuttonclick(MouseEvent event) {
    //     // Get the clicked circle's number from the source ID
    //     String sourceId = ((Circle) event.getSource()).getId();
    //     int lessonNumber = extractLessonNumber(sourceId);
        
    //     if (canStartLesson(lessonNumber)) {
    //         startLesson("Module " + lessonNumber);
    //     }
    // }

    // private boolean canStartLesson(int lessonNumber) {
    //     // First lesson is always available
    //     if (lessonNumber == 1) return true;
        
    //     // Other lessons require previous lesson to be completed
    //     return progressTracker != null && 
    //            progressTracker.getCompletedLessons() >= (lessonNumber - 1);
    // }

    // private void startLesson(String moduleName) {
    //     Lesson lesson = new Lesson(moduleName, new Language("Spanish"));
    //     int score = lesson.playLesson();

    //     if (score >= 80) {
    //         // Update progress tracker
    //         progressTracker.completeLesson();
            
    //         // Update UI
    //         updateCircleColors();
            
    //         // Show success message or transition to next screen
    //         System.out.println("Lesson completed successfully!");
    //     } else {
    //         System.out.println("Please try the lesson again.");
    //     }
    // }

    // private void updateCircleColors() {
    //     int completedLessons = progressTracker.getCompletedLessons();
        
    //     Circle[] circles = {lesson1Circle, lesson2Circle, lesson3Circle, lesson4Circle, lesson5Circle};
        
    //     for (int i = 0; i < circles.length; i++) {
    //         if (circles[i] != null) {
    //             circles[i].getStyleClass().removeAll(
    //                 "lesson-circle-locked", 
    //                 "lesson-circle-available", 
    //                 "lesson-circle-completed"
    //             );
                
    //             if (i < completedLessons) {
    //                 circles[i].getStyleClass().add("lesson-circle-completed");
    //             } else if (i == completedLessons) {
    //                 circles[i].getStyleClass().add("lesson-circle-available");
    //             } else {
    //                 circles[i].getStyleClass().add("lesson-circle-locked");
    //             }
    //         }
    //     }
    // }

    // private int extractLessonNumber(String sourceId) {
        // Extract the lesson number from the circle's ID
        // Assuming IDs are in format "lesson1Circle", "lesson2Circle", etc.
    //     return Integer.parseInt(sourceId.replaceAll("\\D+", ""));
    // }



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

}
