package edu.fiuba.algo3;

import Datos.MensajesUsuario;
import Entidades.Errores.*;
import Vista.*;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.application.Application;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import sonido.ReproductorSonido;

import java.io.File;


public class App extends Application {
    private Stage stage;
    private AppModelo modelo;

    @Override
    public void start(Stage stage){

        this.stage = stage;
        this.modelo = new AppModelo();

        AppVistaInicio vistaInicio = new AppVistaInicio(this);

        ReproductorSonido reproductorSonido = new ReproductorSonido("src/main/resources/sonidos/inicio.mp3");
        reproductorSonido.reproducir();

        stage.setTitle(MensajesUsuario.TITULO_JUEGO);
        stage.setScene(vistaInicio.obtenerEscena());
        stage.show();
    }

    public void mostrarVentanaIngreso()  {
        AppVistaIngreso vistaIngreso = new AppVistaIngreso(this, modelo);
        this.stage.setScene(vistaIngreso.obtenerEscena());
    }


    public void salirDeEscena () {
        this.stage.close();
    }


    public void crearJuego (AppModelo modelo, String ruta) throws DatoNoValido, DatoNoEncontrado, ArchivoNoEncontrado,CantidadMinimaDeJugadores {
        modelo.crearJuego(ruta);

    }

    public void iniciarJuego (AppModelo modelo, String ruta) {
        AppVistaJuego appVistaJuego = new AppVistaJuego(modelo,ruta);
        this.stage.setScene(appVistaJuego.obtenerEscena());
    }
    public static void main(String[] args) {
        launch();
    }

}