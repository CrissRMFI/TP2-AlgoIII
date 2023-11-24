package Entidades.Sistemas;

import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public interface SistemaPosicionamiento {
    public abstract void moverse(Tablero tablero);

    public abstract void posicionar (Posicion posicion);

    public abstract Posicion miPosicion ();
}
