package Entidades.Tablero;

import Entidades.Errores.SinDispositivoDeAzar;
import Entidades.Jugadores.Jugador;

public interface Casillero {
    void entregarElementos(Jugador jugador) throws SinDispositivoDeAzar;
}
