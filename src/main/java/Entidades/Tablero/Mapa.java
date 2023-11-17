package Entidades.Tablero;

import Entidades.Elementos.ValorAzar;
import Entidades.ElementosMapa;

public interface Mapa {
    public  void ubicar(ElementosMapa e, Posicion posicion);

    public Casillero obtenerCasillero (Posicion posicion);

    public PosicionLineal calcularPosicion (ValorAzar valor);

    public Posicion obtenerPosicionInicial ();

}
