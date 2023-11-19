package Entidades.Tablero;
import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Jugador;
import Entidades.ListaCircular;

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
}