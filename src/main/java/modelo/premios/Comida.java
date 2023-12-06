package modelo.premios;

import modelo.energia.Energia;
import modelo.jugadores.Jugador;

public class Comida implements Premio {


    @Override
    public void interactuar(Jugador jugador) {
        jugador.afectarEnergia(this.entregarEnergia());
    }

    private Energia entregarEnergia() {
        return new Energia(15);
    }


}