package edu.fiuba.algo3;

import datos.MensajesUsuario;
import edu.fiuba.algo3.modelo.AppModelo;
import entidades.errores.ArchivoNoEncontrado;
import entidades.errores.CantidadMinimaDeJugadores;
import entidades.errores.DatoNoEncontrado;
import entidades.errores.DatoNoValido;
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
        stage.setMaximized(false);
        this.mediaPlayer.stop();
        AppVistaIngreso vistaIngreso = new AppVistaIngreso(this, modelo);
        this.stage.setScene(vistaIngreso.obtenerEscena());
        String rutaSonido = "src/main/resources/sonidos/musicaIngresoJugadores.mp3";
        this.media = new Media(new File(rutaSonido).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.setVolume(0.15);
        this.mediaPlayer.play();
        stage.setMaximized(true);
    }

    public void salirDeEscena() {
        this.stage.close();
    }

    public void crearJuego(AppModelo modelo, String ruta) throws DatoNoValido, DatoNoEncontrado, ArchivoNoEncontrado, CantidadMinimaDeJugadores {
        modelo.crearJuego(ruta);
    }

    public void iniciarJuego(AppModelo modelo, String ruta) {
        stage.setMaximized(false);
        AppVistaJuego appVistaJuego = new AppVistaJuego(modelo, ruta);
        this.stage.setScene(appVistaJuego.obtenerEscena());
        stage.setMaximized(true);
    }

    public static void main(String[] args) {
        launch();
    }
}