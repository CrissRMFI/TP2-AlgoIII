package Entidades.Tablero;

import Entidades.Jugadores.Jugador;

import java.util.LinkedList;

public class CasilleroFinal implements Casillero{
    private Posicion posicion;
    private LinkedList<Jugador> jugadores;

    public CasilleroFinal (Posicion posicion) {
        this.posicion = posicion;
        this.jugadores = new LinkedList<Jugador>();
    }
    @Override
    public void entregarElementos(Jugador jugador) {

    }
}
