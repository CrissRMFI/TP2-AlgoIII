package componentes.verificador;

import componentes.GladiadorVista;
import componentes.SeleccionMapa;
import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.AppModelo;
import entidades.errores.NombreDeJugadorConMenosDe4CaracteresExcepcion;
import entidades.jugadores.Gladiador;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class VerificadorGladiador extends Verificador {
    @Override
    public boolean revisar(LinkedList<TextField> nombresJugadores, App controlador, AppModelo modelo, SeleccionMapa seleccionMapa) {
        boolean algunNombreTieneMenosDe4Caracteres = false;
        modelo.clearJugadores();
        for (int i = 0; i < nombresJugadores.size(); i++){
            if (nombresJugadores.get(i).getText().isEmpty()) {
                nombresJugadores.get(i).setStyle("");
                continue;
            }
            try{
                nombresJugadores.get(i).setStyle("");
                Gladiador gladiador = new Gladiador(nombresJugadores.get(i).getText());
                modelo.agregarJugador(gladiador);
                modelo.agregarJugador(new GladiadorVista(gladiador, i+1));
            } catch (NombreDeJugadorConMenosDe4CaracteresExcepcion e) {
                nombresJugadores.get(i).setStyle(" -fx-border-color: red; -fx-border-width: 2px;");
                algunNombreTieneMenosDe4Caracteres = true;
            }
        }
        if (algunNombreTieneMenosDe4Caracteres){
            return false;
        }
        return revisarSiguiente(nombresJugadores, controlador, modelo, seleccionMapa);
    }
}
