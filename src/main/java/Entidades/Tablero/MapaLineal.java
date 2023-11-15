package Entidades.Tablero;

import Entidades.Elementos.ValorAzar;
import Entidades.ElementosMapa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MapaLineal<T> implements Mapa {

    private Map<Posicion, Casillero> casilleros;

    private int y = 0;
    public MapaLineal(int cantidadCasilleros, ElementosMapa elementosMapa) {
        this.casilleros = new HashMap<>();

        for (int i = 0; i < cantidadCasilleros; i++) {
            Posicion posicion = new Posicion(i,y);
            Casillero casillero = new Casillero(posicion);
            casillero.recibirElemento(elementosMapa);
            casilleros.put(posicion, casillero);
        }
    }

    @Override
    public void ubicar(ElementosMapa e, Posicion posicion) {
       Casillero casillero = this.obtenerCasillero(posicion);
       casillero.recibirElemento(e);
    }

    @Override
    public Posicion calcularPosicion(ValorAzar valor) {
        return new Posicion(1,y);
    }

    @Override
    public Casillero obtenerCasillero(Posicion posicion) {
        return casilleros.get(posicion);
    }
}
