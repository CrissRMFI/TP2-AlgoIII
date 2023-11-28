package edu.fiuba.algo3;

import Vista.Login;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {

       new Login().start(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}