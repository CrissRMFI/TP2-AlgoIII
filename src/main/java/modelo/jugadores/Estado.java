package modelo.jugadores;

import modelo.tablero.Casillero;
import modelo.tablero.Mapa;

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
