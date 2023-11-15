package Entidades.Tablero;

import Entidades.Elementos.ValorAzar;
import Entidades.ElementosMapa;

import java.util.LinkedList;
import java.util.List;
public interface Mapa {
    public  void ubicar(ElementosMapa e, Posicion posicion);

    public Casillero obtenerCasillero (Posicion posicion);

    public Posicion calcularPosicion (ValorAzar valor);

}
