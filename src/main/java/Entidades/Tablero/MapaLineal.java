package Entidades.Tablero;

import Entidades.Elementos.ValorAzar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MapaLineal implements Mapa {

    private final Map<Posicion, Casillero> casilleros;
    private Posicion posicionFinal;
    private final ConstructorMapa constructorMapa = new ConstructorLineal();


    public MapaLineal(InformacionMapa informacionMapa) {

        this.casilleros = new HashMap<>();
        LinkedList<Casillero> c = informacionMapa.construirCasilleros();
        this.constructorMapa.construirMapa(this.casilleros,c);
        int fin = c.size() + 1;
        this.posicionFinal = new PosicionLineal(fin);
    }

    @Override
    public PosicionLineal calcularPosicion(ValorAzar valor) {
        return new PosicionLineal(valor.obtenerValor());
    }

    @Override
    public Casillero obtenerCasillero(Posicion posicion) {

        for (Posicion p : this.casilleros.keySet()) {
            if (p.igual(posicion)) {
                return casilleros.get(p);
            }
        }
        return null;
    }

    @Override
    public Posicion obtenerPosicionInicial() {
        return new PosicionLineal(0);
    }

    @Override
    public Posicion obtenerPosicionFinal() {
        return this.posicionFinal;
    }

    @Override
    public Posicion posicionMedio() {
        int tamanio = this.casilleros.size() -1 ;
        return new PosicionLineal(tamanio/2);
    }
}