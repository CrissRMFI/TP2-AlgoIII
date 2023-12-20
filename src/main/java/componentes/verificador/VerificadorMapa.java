package componentes.verificador;

import componentes.SeleccionMapa;
import datos.InformacionMapaEnJSON;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import entidades.errores.ArchivoNoEncontrado;
import entidades.errores.DatoNoEncontrado;
import entidades.errores.DatoNoValido;
import entidades.tablero.Mapa;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class VerificadorMapa extends Verificador {

    @Override
    public boolean revisar(LinkedList<TextField> nombresJugadores, App controlador, AppModelo modelo, SeleccionMapa seleccionMapa) {
        String ruta = seleccionMapa.obtenerRutaMapa();
        try{
            InformacionMapaEnJSON informacionMapaEnJSON = new InformacionMapaEnJSON(ruta);
            modelo.agregarMapa(new Mapa(informacionMapaEnJSON));
            modelo.crearAlgoRoma();
        } catch (ArchivoNoEncontrado e) {
            String mensaje = "EL ARCHIVO SELECCIONADO NO FUE ENCONTRADO.";
            Alert alerta = new Alert(Alert.AlertType.WARNING, mensaje);
            alerta.showAndWait();
            return false;
        } catch (DatoNoValido | DatoNoEncontrado f){
            String mensaje = "EXISTE UN ERROR EN EL ARCHIVO SELECCIONADO.";
            Alert alerta = new Alert(Alert.AlertType.WARNING, mensaje);
            alerta.showAndWait();
            return false;
        }
        return revisarSiguiente(nombresJugadores, controlador, modelo, seleccionMapa);
    }
}
