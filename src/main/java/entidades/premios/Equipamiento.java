package entidades.premios;

import entidades.jugadores.Jugador;

public class Equipamiento implements Premio {
    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

}