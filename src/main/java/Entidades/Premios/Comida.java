package Entidades.Premios;

import Entidades.Elementos.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class Comida implements Interactuable {

    private boolean interactuo = false;
    @Override
    public void interactuar(Jugador jugador) {
        jugador.afectarEnergia(this.entregarEnergia());
        this.setInteractuo();
    }

    private Energia entregarEnergia () {
        return new Energia (15);
    }

    @Override
    public boolean esPremio() {
        return true;
    }

    private void setInteractuo () {
        this.interactuo = true;
    }

    @Override
    public boolean interactuo() {
        return this.interactuo;
    }
}