package Entidades.Elementos;

import Entidades.Errores.SinDispositivoDeAzar;
import Entidades.Jugadores.Jugador;

public interface Interactuable {
    void interactuar (Jugador jugador) throws SinDispositivoDeAzar;

    boolean esPremio ();

    boolean interactuo ();
}