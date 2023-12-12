
package edu.fiuba.algo3;

import Datos.MensajesUsuario;
import Entidades.Errores.CantidadMinimaDeJugadores;
import Vista.*;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application {
    private Stage stage;
    private AppModelo modelo;

    @Override
    public void start(Stage stage){

        this.stage = stage;
        this.modelo = new AppModelo();

        AppVistaInicio vistaInicio = new AppVistaInicio(this);

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

    public void iniciarJuego (AppModelo modelo) throws CantidadMinimaDeJugadores {
        modelo.crearJuego();
        AppVistaJuego appVistaJuego = new AppVistaJuego(modelo, this.stage);


        this.stage.setScene(appVistaJuego.obtenerEscena());
    }


    public static void main(String[] args) {
        launch();
    }

}