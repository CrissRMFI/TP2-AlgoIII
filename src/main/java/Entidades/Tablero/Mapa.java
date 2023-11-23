package Entidades.Tablero;

import Entidades.Elementos.ValorAzar;

public interface Mapa {
    public abstract Casillero obtenerCasillero (Posicion posicion);

    public abstract Posicion calcularPosicion (ValorAzar valor);

    public abstract Posicion obtenerPosicionInicial ();

    public abstract Posicion obtenerPosicionFinal();

    public abstract Posicion obtenerPosicionDelMedio();
}