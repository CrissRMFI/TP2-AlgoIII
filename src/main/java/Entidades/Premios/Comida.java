package Entidades.Premios;

import Entidades.ElementoMapa;
import Entidades.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class Comida implements ElementoMapa,Premio {


    @Override
    public void interactuar(Jugador jugador) {
        jugador.afectarEnergia(this.entregarEnergia());
    }

    private Energia entregarEnergia () {
        return new Energia (15);
    }

    @Override
    public boolean soyJugador() {
        return false;
    }
}