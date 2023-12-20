package componentes.verificador;

import componentes.SeleccionMapa;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class VerificadorDeExistenciaDeNombres extends Verificador{
    @Override
    public boolean revisar(LinkedList<TextField> nombresJugadores, App controlador, AppModelo modelo, SeleccionMapa seleccionMapa) {
        int contadorNombresVacios = 0;
        for (TextField nombre : nombresJugadores){
            if (nombre.getText().trim().isEmpty()){
                contadorNombresVacios++;
            }
        }

        if (contadorNombresVacios == nombresJugadores.size()){
            String mensaje = "DEBE INGRESAR MINIMO 2 JUGADORES.";
            Alert alerta = new Alert(Alert.AlertType.WARNING, mensaje);
            alerta.showAndWait();
            return false;
        }

        return revisarSiguiente(nombresJugadores, controlador, modelo, seleccionMapa);
    }
}
