package modelo.obstaculos;

import modelo.jugadores.Jugador;

public class Fiera extends Obstaculo{

    @Override
    public void interactuar(Jugador jugador) {
        jugador.defenderse();
    }

}