package modelo.obstaculos;

import modelo.elementos.Turno;
import modelo.jugadores.Jugador;

public class Lesion extends Obstaculo {
    private Turno turnosAPerder = new Turno(1);
    @Override
    public void interactuar(Jugador jugador) {
        jugador.perderTurnos(this.turnosAPerder);
    }
}