package Entidades.Tablero;

import Entidades.Elementos.ValorAzar;
import Entidades.ElementosMapa;
import Entidades.Jugadores.Gladiador;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MapaLineal<T> implements Mapa {

    private Map<Posicion, Casillero> casilleros;
    private int y = 0;


    public MapaLineal(ElementosMapa[][] elementosMapa) {

        this.casilleros = new HashMap<>();

        Posicion posicionInicial = new Posicion(0,0);
        Casillero casilleroInicial = new Casillero(posicionInicial);
        casilleros.put(posicionInicial,casilleroInicial);


        for (int i = 0; i < elementosMapa.length; i++) {
            Posicion posicion = new Posicion(i, 0);
            Casillero casillero = new Casillero(posicion);

            for (int j = 0; j < elementosMapa[i].length; j++) {
                ElementosMapa elemento = elementosMapa[i][j];
                casillero.recibirElemento(elemento);
            }

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
        return new Posicion(valor.obtenerValor(), y);
    }

    @Override
    public Casillero obtenerCasillero(Posicion posicion) {

        for (Posicion p : this.casilleros.keySet()) {
            if (p.comparar(posicion)) {
                return casilleros.get(p);
            }
        }
        return null;
    }
}
