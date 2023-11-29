package Vista;

import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

import java.util.LinkedList;

public class LoginVistaModelo {

    private final LinkedList<String> usuarios = new LinkedList<>();

    private final LoginModelo model = new LoginModelo();

    private Stage stage;

    public void agregarUsuario (String nombre) {
        this.usuarios.add(nombre);
    }
    public void iniciar() {

        for (int i=0; i< this.usuarios.size(); i++) {
            Jugador jugador = this.crearGladiador(this.usuarios.get(i));
            this.model.recibirJugador(jugador);
        }

        this.model.iniciar(this.stage);

    }

    public void implementarStage (Stage stage) {
        this.stage = stage;
    }

    private Jugador crearGladiador (String nombre) {
        return new Gladiador(nombre);
    }
}
