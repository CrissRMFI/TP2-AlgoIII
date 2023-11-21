package Entidades.Obstaculos;

import Entidades.Jugadores.Jugador;

public class Piedra extends Obstaculo {
    @Override
    public void interactuar(Jugador jugador) {
        jugador.perderTurnos();
    }

}