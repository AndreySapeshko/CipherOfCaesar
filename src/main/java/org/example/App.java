package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage primaryStage;
    private static String title = "CRYPTO-MACHINE \"CAESAR\" / crypto with key";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1200, 600);
        InputStream imageStream = getClass().getResourceAsStream("/java-logo.png");
        Image logo = new Image(imageStream);
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle(title);
        stage.show();
        primaryStage = stage;
    }

    static void setRoot(String fxml, String newTitle) throws IOException {
        primaryStage.setTitle(newTitle);
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static TextArea getTextArea(String idTextArea) {
        return (TextArea) scene.lookup(idTextArea);
    }

    static TextField getTextField(String idTextField) {
        return (TextField) scene.lookup(idTextField);
    }

    static Button getButton(String idButton) {
        return (Button) scene.lookup(idButton);
    }

    public static void main(String[] args) {
        launch();
    }

}