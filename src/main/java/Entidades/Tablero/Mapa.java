package Entidades.Tablero;

import Entidades.Elementos.Interactuable;
import Entidades.Elementos.ValorAzar;

public interface Mapa {
    public  void ubicar(Interactuable interactuable, Posicion posicion);

    public Casillero obtenerCasillero (Posicion posicion);

    public PosicionLineal calcularPosicion (ValorAzar valor);

    public Posicion obtenerPosicionInicial ();

}