package Entidades.Tablero;

import Entidades.ElementoMapa;
import Entidades.Interactuable;
import Entidades.Jugadores.Jugador;
import Vista.CasilleroVista;

import java.util.LinkedList;

public abstract class Casillero {
    protected LinkedList<ElementoMapa> elementos = new LinkedList<>();
    protected int x;
    protected int y;


    public void recibirElemento (ElementoMapa elemento) {
        this.elementos.add(elemento);
    }

    public void entregarElementos(Jugador jugador) {
        for (int i=0;i< this.elementos.size();i++) {
            ElementoMapa elementoMapa = this.elementos.get(i);
            if (!elementoMapa.soyJugador()) {
                Interactuable interactuable = (Interactuable) elementoMapa;
                interactuable.interactuar(jugador);
            }
        }
    }
    public abstract boolean soyMeta ();

    public boolean equals (Casillero casillero) {
        return this.x == casillero.x && this.y == casillero.y;
    }
}
