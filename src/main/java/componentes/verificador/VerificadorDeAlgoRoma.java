package componentes.verificador;

import componentes.SeleccionMapa;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import entidades.errores.CantidadMinimaDeJugadores;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class VerificadorDeAlgoRoma extends Verificador{
    @Override
    public boolean revisar(LinkedList<TextField> nombresJugadores, App controlador, AppModelo modelo, SeleccionMapa seleccionMapa) {
        try{
            modelo.comenzarPartida();
            controlador.iniciarJuego(modelo, seleccionMapa.obtenerRutaMapa());
        } catch (CantidadMinimaDeJugadores e) {
            modelo.clearJugadores();
            String mensaje = "NECESITAMOS MINIMO DOS JUGADORES.";
            Alert alerta = new Alert(Alert.AlertType.WARNING, mensaje);
            alerta.showAndWait();
            return false;
        }
        return true;
    }
}
