package edu.fiuba.algo3;

import Vista.LoginVista;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {

    @Override
    public void start(Stage stage) {

        LoginVista login = new LoginVista();
        login.crearVista();


    }

    public static void main(String[] args) {
        launch();
    }

}