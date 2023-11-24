package Entidades.Obstaculos;

import Entidades.Elementos.Turno;
import Entidades.Jugadores.Jugador;

public class Piedra extends Obstaculo {
    private Turno turnosAPerder = new Turno(1);
    @Override
    public void interactuar(Jugador jugador) {
        jugador.perderTurnos(this.turnosAPerder);
    }

}