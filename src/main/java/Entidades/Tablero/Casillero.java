package Entidades.Tablero;

import Entidades.Errores.SinDispositivoDeAzar;
import Entidades.Jugadores.Jugador;

public interface Casillero {
    public abstract void entregarElementos(Jugador jugador) throws SinDispositivoDeAzar;
}
