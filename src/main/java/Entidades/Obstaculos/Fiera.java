package Entidades.Obstaculos;


import Entidades.Jugadores.Jugador;

public class Fiera extends Obstaculo {

    @Override
    public void interactuar(Jugador jugador) {
        jugador.defenderse();
    }

}