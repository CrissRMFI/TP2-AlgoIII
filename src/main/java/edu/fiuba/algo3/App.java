package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.EscenaDeInicio;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        EscenaDeInicio escenaDeInicio = new EscenaDeInicio(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}