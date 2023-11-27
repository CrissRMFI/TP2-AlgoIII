package Entidades.Premios;

import Entidades.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class Comida implements Interactuable,Premio {


    @Override
    public void interactuar(Jugador jugador) {
        jugador.afectarEnergia(this.entregarEnergia());
    }

    private Energia entregarEnergia () {
        return new Energia (15);
    }

}