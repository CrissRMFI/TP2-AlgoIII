package Entidades.Tablero;

import Entidades.Elementos.ValorAzar;
import Entidades.ElementosMapa;

import java.util.HashMap;
import java.util.Map;

public class MapaLineal<T> implements Mapa {

    private Map<PosicionLineal, Casillero> casilleros;

    public MapaLineal(ElementosMapa[][] elementosMapa) {
        this.casilleros = new HashMap<>();

        PosicionLineal posicionLinealInicial = new PosicionLineal(0);
        Casillero casilleroInicial = new Casillero(posicionLinealInicial);
        casilleros.put(posicionLinealInicial,casilleroInicial);

        for (int i = 0; i < elementosMapa.length; i++) {
            PosicionLineal posicionLineal = new PosicionLineal(i);
            Casillero casillero = new Casillero(posicionLineal);

            for (int j = 0; j < elementosMapa[i].length; j++) {
                ElementosMapa elemento = elementosMapa[i][j];
                casillero.recibirElemento(elemento);
            }

            casilleros.put(posicionLineal, casillero);
        }
    }

    @Override
    public void ubicar(ElementosMapa e, Posicion posicion) {
       Casillero casillero = this.obtenerCasillero(posicion);
       casillero.recibirElemento(e);
    }

    @Override
    public PosicionLineal calcularPosicion(ValorAzar valor) {
        return new PosicionLineal(valor.obtenerValor());
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

    @Override
    public Posicion obtenerPosicionInicial() {
        return new PosicionLineal(0);
    }
}
