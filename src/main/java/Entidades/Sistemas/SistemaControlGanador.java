package Entidades.Sistemas;

import Entidades.AlgoRoma;
import Entidades.Equipo.Equipamiento;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;

public class SistemaControlGanador {
    private Tablero tablero;

    public SistemaControlGanador (Tablero tablero) {
        this.tablero = tablero;
    }
    public void gano (Jugador jugador, AlgoRoma algoRoma) {

        Posicion posicion = this.tablero.posicionFinal();
        boolean cumplePosicion = jugador.miPosicion().esMayorIgual(posicion);
        boolean cumpleEquipo = jugador.compararEquipo(Equipamiento.LLAVE);
        if (cumplePosicion && cumpleEquipo) {
            algoRoma.finalizarJuego(jugador);
        }
        if (cumplePosicion && !cumpleEquipo) {
            posicion = this.tablero.posicionMedio();
            jugador.posicionar(posicion);
        }
    }
}
