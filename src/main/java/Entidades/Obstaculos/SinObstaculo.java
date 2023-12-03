package Entidades.Obstaculos;

import Entidades.Jugadores.Jugador;

public class SinObstaculo extends Obstaculo{
    @Override
    public void interactuar(Jugador jugador) {

    }

    @Override
    public boolean soyJugador() {
        return false;
    }
}
