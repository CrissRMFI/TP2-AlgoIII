package Entidades.Tablero;

import Entidades.Jugadores.Jugador;

import java.util.LinkedList;

public class CasilleroInicial implements Casillero{
    private Posicion posicion;

    public CasilleroInicial (Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public void entregarElementos(Jugador jugador) {

    }
}
