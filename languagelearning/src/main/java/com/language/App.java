package com.language;

import java.io.IOException;

import com.controllers.QuestionController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        setStage(stage);
        scene = new Scene(loadFXML("login"), 430, 750);
        stage.setScene(scene);
        stage.show();
    }

    // public static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    private static QuestionController currentController;

public static void setCurrentController(QuestionController controller) {
    currentController = controller;
}

public static QuestionController getCurrentController() {
    return currentController;
}

private static Stage stage;

public static void setStage(Stage primaryStage) {
    stage = primaryStage;
}

public static Stage getStage() {
    return stage;
}

public static FXMLLoader setRoot(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    scene.setRoot(fxmlLoader.load());
    return fxmlLoader;
}

}