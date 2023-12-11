package Entidades.Obstaculos;


import Entidades.Jugadores.InHabilitado;
import Entidades.Jugadores.Jugador;

public class Lesion extends Obstaculo {

    private final int turnosAPerder;
    public Lesion() {
        this.turnosAPerder = 1;
    }

    @Override
    public void interactuar(Jugador jugador) {
        jugador.setEstado(new InHabilitado(jugador, turnosAPerder));
    }
}