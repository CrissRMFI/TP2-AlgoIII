package entidades.obstaculos;


import entidades.jugadores.Jugador;

public class Fiera extends Obstaculo {

    @Override
    public void interactuar(Jugador jugador) {
        jugador.defenderse();
    }

}