package Entidades.Obstaculos;


import Entidades.Jugadores.InhabilitadoTurnos;
import Entidades.Jugadores.Jugador;
import Entidades.Jugadores.Turno;

public class Lesion extends Obstaculo {

    private final Turno turnosAPerder;

    public Lesion() {
        this.turnosAPerder = new Turno(1);
    }

    @Override
    public void interactuar(Jugador jugador) {
        jugador.setEstado(new InhabilitadoTurnos(jugador, turnosAPerder));
    }
}