package entidades.tablero;

import entidades.Interactuable;
import entidades.jugadores.Jugador;

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

    public boolean esIgualQue(Casillero casillero) {
        return this.x == casillero.x && this.y == casillero.y;
    }
}
