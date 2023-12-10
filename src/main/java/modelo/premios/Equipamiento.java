package modelo.premios;

import modelo.jugadores.Jugador;

public class Equipamiento implements Premio {

    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

}