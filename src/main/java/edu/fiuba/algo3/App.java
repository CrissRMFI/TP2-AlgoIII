package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        stage.setTitle("AlgoRoma");

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        StackPane layout =  new StackPane(label);

        Button boton = new Button();
        boton.setText("Solo soy un ejemplo");
        layout.getChildren().add(boton);

        /*
        Label unLabel = new Label();
        unLabel.setText("Que se yo, es solo una prueba");
        layout.getChildren().add(unLabel);
         */

        TextField textField = new TextField();
        layout.getChildren().add(textField);

        var scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}