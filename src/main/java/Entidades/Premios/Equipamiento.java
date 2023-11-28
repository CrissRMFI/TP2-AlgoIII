package Entidades.Premios;

import Entidades.Interactuable;
import Entidades.Jugadores.Jugador;
import Entidades.Premios.Premio;

public class Equipamiento implements Interactuable, Premio {
    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

}