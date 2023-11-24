package Entidades.Tablero;
import Entidades.Elementos.ValorAzar;

public class Tablero {
    private final Mapa mapa;

    public Tablero(Mapa mapa) {
        this.mapa = mapa;
    }

    public Casillero obtenerCasillero(Posicion posicion) {
        return this.mapa.obtenerCasillero(posicion);
    }

    public Posicion calcularPosicion (ValorAzar valor) {
        return this.mapa.calcularPosicion(valor);
    }

    public Posicion posicionInicial () {
        return this.mapa.obtenerPosicionInicial();
    }

    public Posicion posicionFinal () {
        return this.mapa.obtenerPosicionFinal();
    }

    public Posicion posicionMedio() {
        return mapa.obtenerPosicionDelMedio();
    }

}