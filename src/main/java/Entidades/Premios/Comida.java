package Entidades.Premios;

import Entidades.Elementos.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class Comida implements Premio {

    @Override
    public void interactuar(Jugador jugador) {
        jugador.afectarEnergia(this.entregarEnergia());
    }

    private Energia entregarEnergia () {
        return new Energia (15);
    }

}