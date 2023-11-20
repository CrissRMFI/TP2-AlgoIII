package Entidades.Tablero;

import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Jugador;

public interface Mapa {
    Casillero obtenerCasillero (Posicion posicion);

    Posicion calcularPosicion (ValorAzar valor);

    Posicion obtenerPosicionInicial ();

    Posicion obtenerPosicionFinal();

    Posicion posicionMedio ();
}