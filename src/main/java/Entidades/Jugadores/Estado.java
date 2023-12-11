package Entidades.Jugadores;


import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;

public abstract class Estado {
    protected Jugador jugador;

    public Estado(Jugador jugador) {
        this.jugador = jugador;
    }

    abstract public Casillero mover(Mapa mapa, Casillero casillero);

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
