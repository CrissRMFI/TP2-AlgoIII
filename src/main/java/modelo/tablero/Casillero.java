package modelo.tablero;

import modelo.Interactuable;
import modelo.jugadores.Jugador;

import java.util.LinkedList;

public class Casillero {
    protected LinkedList<Interactuable> elementos = new LinkedList<>();
    protected int x;
    protected int y;

    public Casillero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void recibirElemento(Interactuable elemento) {
        this.elementos.add(elemento);
    }

    public void entregarElementos(Jugador jugador) {
        for (Interactuable elementoMapa : this.elementos) {
            elementoMapa.interactuar(jugador);
        }
    }

    public boolean equals(Casillero casillero) {
        return this.x == casillero.x && this.y == casillero.y;
    }

    public int conseguirX() {
        return this.x;
    }

    public int conseguirY() {
        return this.y;
    }
}
