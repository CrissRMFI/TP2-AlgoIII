package Entidades.Elementos;

import Entidades.Jugadores.Jugador;

public interface Interactuable {
    public abstract void interactuar (Jugador jugador);

    public abstract boolean esPremio ();

    public abstract boolean interactuo ();
}