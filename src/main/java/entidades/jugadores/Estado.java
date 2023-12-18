package entidades.jugadores;


import entidades.tablero.Casillero;
import entidades.tablero.Mapa;

public abstract class Estado {
    protected Jugador jugador;

    public Estado(Jugador jugador) {
        this.jugador = jugador;
    }

    public abstract Casillero mover(Mapa mapa, Casillero casillero);
}
