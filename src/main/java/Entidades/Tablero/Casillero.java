package Entidades.Tablero;

import Entidades.Interactuable;
import Entidades.Jugadores.Jugador;

import java.util.LinkedList;

public  class Casillero {
    protected LinkedList<Interactuable> elementos = new LinkedList<>();
    protected int x;
    protected int y;

    public Casillero(int x,int y) {
        this.x = x;
        this.y = y;
    }
    public void recibirElemento (Interactuable elemento) {
        this.elementos.add(elemento);
    }

    public void entregarElementos(Jugador jugador) {
        for (int i=0; i< this.elementos.size(); i++) {
            Interactuable elementoMapa = this.elementos.get(i);
            Interactuable interactuable = elementoMapa;
            interactuable.interactuar(jugador);
        }
    }
    public boolean equals (Casillero casillero) {
        return this.x == casillero.x && this.y == casillero.y;
    }

    public int conseguirX(){
        return this.x;
    }

    public int conseguirY(){
        return this.y;
    }

    public boolean comparar(Casillero casillero) {
        return this.x == casillero.x && this.y == casillero.y;
    }
}
