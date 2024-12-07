package com.language;

import java.io.IOException;

import com.model.Lesson;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
    private static Lesson currentLesson;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 430, 750); // Start with the home screen
        stage.setScene(scene);
        stage.setTitle("CockySpeak Language App");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Lesson getCurrentLesson() {
        return currentLesson;
    }

    public static void setCurrentLesson(Lesson lesson) {
        currentLesson = lesson;
    }
}
