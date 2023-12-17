package entidades.obstaculos;


import entidades.jugadores.Jugador;

public class Fiera implements Obstaculo {

    @Override
    public void interactuar(Jugador jugador) {
        jugador.defenderse();
    }

}