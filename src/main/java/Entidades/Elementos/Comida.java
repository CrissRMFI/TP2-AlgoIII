package Entidades.Elementos;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class Comida implements Interactuable {

    @Override
    public void interactuar(Jugador jugador) {
        jugador.afectarEnergia(this.entregarEnergia());
    }

    private Energia entregarEnergia () {
        return new Energia (15);
    }

}
