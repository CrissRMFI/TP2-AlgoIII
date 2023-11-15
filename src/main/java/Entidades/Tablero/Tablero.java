package Entidades.Tablero;
import java.util.LinkedList;

import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Gladiador;

public class Tablero {

    private Mapa mapa;
    private LinkedList<Gladiador> gladiadores;

    public Tablero(Mapa mapa) {
        this.mapa = mapa;
        this.gladiadores = new LinkedList<>();
    }

    public void agregarJugador(Gladiador gladiador) {
        this.gladiadores.add(gladiador);
        Posicion posicion = new Posicion(0,0);
        mapa.ubicar(gladiador,posicion);


    }

    public Casillero obtenerCasillero(Posicion posicion) {
        return this.mapa.obtenerCasillero(posicion);
    };

    public Posicion calcularPosicion (ValorAzar valor) {
        return this.mapa.calcularPosicion(valor);
    }

    public void moverJugador(Gladiador gladiador,Posicion posicion){
        gladiador.posicionar(posicion);
        this.mapa.ubicar(gladiador,posicion);
    }
}

