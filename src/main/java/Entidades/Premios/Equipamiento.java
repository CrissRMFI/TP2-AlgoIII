package Entidades.Premios;

import Entidades.Jugadores.Jugador;

public class Equipamiento implements Premio {
    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

}