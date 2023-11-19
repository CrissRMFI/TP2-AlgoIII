package Entidades.Tablero;

import Entidades.Elementos.Interactuable;
import Entidades.Elementos.ValorAzar;

import java.util.HashMap;
import java.util.Map;

public class MapaLineal implements Mapa {

    private final Map<Posicion, Casillero> casilleros;

    public MapaLineal(Interactuable[][] elementosMapa) {
        this.casilleros = new HashMap<>();

        PosicionLineal posicionLinealInicial = new PosicionLineal(0);
        this.agregarCasillero(posicionLinealInicial);

        for (int i = 1; i < elementosMapa.length; i++) {
            PosicionLineal posicionLineal = new PosicionLineal(i);
            this.agregarCasillero(posicionLineal);

            for (int j = 0; j < elementosMapa[i].length; j++) {
                Interactuable elemento = elementosMapa[i][j];
                Casillero casillero = this.obtenerCasillero(posicionLineal);
                casillero.recibirElemento(elemento);
            }
        }
    }

    @Override
    public void ubicar(Interactuable interactuable, Posicion posicion) {
        Casillero casillero = this.obtenerCasillero(posicion);
        casillero.recibirElemento(interactuable);

    }

    public void agregarCasillero (Posicion posicion) {
        Casillero casillero = new Casillero(posicion);
        this.casilleros.put(posicion,casillero);
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
