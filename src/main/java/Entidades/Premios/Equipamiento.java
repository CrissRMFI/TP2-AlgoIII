package Entidades.Premios;

import Entidades.ElementoMapa;
import Entidades.Interactuable;
import Entidades.Jugadores.Jugador;
import Entidades.Premios.Premio;

public class Equipamiento implements ElementoMapa, Premio {
    @Override
    public boolean soyJugador() {
        return false;
    }

    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

}