package Entidades.Elementos;

import Entidades.Errores.SinDispositivoDeAzar;
import Entidades.Jugadores.Jugador;

public interface Interactuable {
    public abstract void interactuar (Jugador jugador) throws SinDispositivoDeAzar;

    public abstract boolean esPremio ();

    public abstract boolean interactuo ();
}