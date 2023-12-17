package entidades.premios;

import entidades.Interactuable;
import entidades.energia.Energia;
import entidades.jugadores.Jugador;

public class Comida implements Interactuable {


    @Override
    public void interactuar(Jugador jugador) {
        jugador.afectarEnergia(this.entregarEnergia());
    }

    private Energia entregarEnergia() {
        return new Energia(15);
    }


}