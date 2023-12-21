package edu.fiuba.algo3;

import datos.MensajesUsuario;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import vista.AppVistaIngreso;
import vista.AppVistaInicio;
import vista.AppVistaJuego;

import java.io.File;


public class App extends Application {
    private Stage stage;
    private AppModelo modelo;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage stage) {

        this.stage = stage;
        this.modelo = new AppModelo();

        AppVistaInicio vistaInicio = new AppVistaInicio(this);

        stage.setTitle(MensajesUsuario.TITULO_JUEGO);
        stage.setScene(vistaInicio.obtenerEscena());
        stage.setMaximized(true);
        stage.show();

        String rutaSonido = "src/main/resources/sonidos/inicio.mp3";
        this.media = new Media(new File(rutaSonido).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.play();
    }

    public void mostrarVentanaIngreso() {
        this.mediaPlayer.stop();

        AppVistaIngreso vistaIngreso = new AppVistaIngreso(this, modelo);
        this.stage.setScene(vistaIngreso.obtenerEscena());

        String rutaSonido = "src/main/resources/sonidos/musicaIngresoJugadores.mp3";
        this.media = new Media(new File(rutaSonido).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.setVolume(0.15);
        this.mediaPlayer.play();

    }

    public void salirDeEscena() {
        this.stage.close();
    }


    public void iniciarJuego(AppModelo modelo, String ruta) {
        AppVistaJuego appVistaJuego = new AppVistaJuego(modelo, ruta);
        this.stage.setScene(appVistaJuego.obtenerEscena());
    }

    public static void main(String[] args) {
        launch();
    }
}