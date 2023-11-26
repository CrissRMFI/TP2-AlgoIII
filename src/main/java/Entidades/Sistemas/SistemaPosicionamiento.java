package Entidades.Sistemas;

import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public interface SistemaPosicionamiento {
    void moverse(Tablero tablero);

    void posicionar (Posicion posicion);

    Posicion miPosicion ();
}
