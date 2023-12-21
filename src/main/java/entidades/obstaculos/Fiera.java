package entidades.obstaculos;


import entidades.Interactuable;
import entidades.jugadores.Jugador;

public class Fiera implements Interactuable {

    @Override
    public void interactuar(Jugador jugador) {
        jugador.defenderse();
    }

}