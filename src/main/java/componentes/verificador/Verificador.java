package componentes.verificador;

import componentes.SeleccionMapa;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public abstract class Verificador {
    private Verificador siguiente;

    public static Verificador enlace(Verificador primero, Verificador... cadena){
        Verificador actual = primero;
        for (Verificador siguienteEnCadena: cadena){
            actual.siguiente = siguienteEnCadena;
            actual = siguienteEnCadena;
        }
        return primero;
    }

    public abstract boolean revisar(LinkedList<TextField> nombresJugadores, App controlador,
                                    AppModelo modelo, SeleccionMapa seleccionMapa);

    public boolean revisarSiguiente(LinkedList<TextField> nombresJugadores, App controlador,
                                    AppModelo modelo, SeleccionMapa seleccionMapa){
        if (siguiente == null){
            return true;
        }
        return siguiente.revisar(nombresJugadores, controlador, modelo, seleccionMapa);
    }
}
