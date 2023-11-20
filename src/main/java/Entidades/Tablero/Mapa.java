package Entidades.Tablero;

import Entidades.Elementos.Interactuable;
import Entidades.Elementos.ValorAzar;

public interface Mapa {
    Casillero obtenerCasillero (Posicion posicion);

    Posicion calcularPosicion (ValorAzar valor);

    Posicion obtenerPosicionInicial ();

}