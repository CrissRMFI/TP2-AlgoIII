package Vista;

import Entidades.Jugadores.Jugador;
import javafx.stage.Stage;

import java.util.LinkedList;

public class LoginModelo {

    private LinkedList<Jugador> jugadores = new LinkedList<>();
    public void iniciar (Stage stageLogin) {
        stageLogin.close();
    }

    public void recibirJugador (Jugador jugador) {
        this.jugadores.add(jugador);
    }
}
