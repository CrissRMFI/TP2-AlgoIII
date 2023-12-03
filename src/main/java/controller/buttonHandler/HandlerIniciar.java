package controller.buttonHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HandlerIniciar implements EventHandler<ActionEvent> {
    // capaz cambiar a entrar
    Stage stage;
    Scene proximaEscena;

    public HandlerIniciar(Stage stage, Scene scene) {
        this.stage = stage;
        this.proximaEscena = scene;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boolean fullScreen = stage.isFullScreen();
        stage.setScene(proximaEscena);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(fullScreen);
    }

}
