package Entidades.Premios;

import Entidades.ElementoMapa;
import Entidades.Jugadores.Jugador;

public class SinPremio implements ElementoMapa,Premio {
    @Override
    public boolean soyJugador() {
        return false;
    }

    @Override
    public void interactuar(Jugador jugador) {

    }
}
