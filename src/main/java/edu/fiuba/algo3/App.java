
package edu.fiuba.algo3;

import datos.MensajesUsuario;
import vista.ContenedorSeleccionMapaYJugadores;
import vista.ContenedorMenuPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {
    @Override
    public void start(Stage stage) {

        stage.setTitle(MensajesUsuario.TITULO_JUEGO);

        ContenedorSeleccionMapaYJugadores login = new ContenedorSeleccionMapaYJugadores(stage);
        Scene escenaJuego = new Scene(login, 800, 480);

        ContenedorMenuPrincipal contenedorMenuPrincipal = new ContenedorMenuPrincipal(stage, escenaJuego);
        Scene escenaMenuPrincipal = new Scene(contenedorMenuPrincipal, 600, 600);

        stage.setScene(escenaMenuPrincipal);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}