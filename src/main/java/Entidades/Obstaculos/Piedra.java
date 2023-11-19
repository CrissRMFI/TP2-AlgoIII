package Entidades.Obstaculos;

import Entidades.Jugadores.Jugador;

public class Piedra implements Obstaculo {
    @Override
    public void interactuar(Jugador jugador) {
        jugador.perderTurnos();
    }

    @Override
    public boolean esPremio() {
        return true;
    }
}
