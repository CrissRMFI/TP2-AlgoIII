package Entidades.Tablero;

import Entidades.Interactuable;
import Entidades.Jugadores.Jugador;

import java.util.LinkedList;

public abstract class Casillero {
    protected LinkedList<Interactuable> elementos = new LinkedList<>();

    public void recibirElemento (Interactuable elemento) {
        this.elementos.add(elemento);
    }
    public void entregarElementos(Jugador jugador) {
        for (int i=0;i< this.elementos.size();i++) {
            Interactuable interactuable = this.elementos.get(i);
            if (interactuable != null) {
                interactuable.interactuar(jugador);
            }
        }
    }
}
