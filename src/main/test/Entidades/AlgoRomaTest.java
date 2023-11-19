package Entidades;

import Entidades.Jugadores.Gladiador;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.InformacionMapaEnMatriz;
import Entidades.Tablero.Mapa;
import Entidades.Tablero.MapaLineal;
import Entidades.Tablero.Tablero;
import Entidades.Elementos.Interactuable;
import Entidades.Obstaculos.FieraSalvaje;

public class AlgoRomaTest {
    public Mapa mapaConFieraSalvaje() {
        int cantidadCasilleros = 30;

        Interactuable[][] elementosMapa = new Interactuable[cantidadCasilleros][1];

        for (int i = 0; i < cantidadCasilleros; i++) {
            elementosMapa[i][0] = new FieraSalvaje();
        }

        InformacionMapaEnMatriz informacionMapaEnMatriz = new InformacionMapaEnMatriz(elementosMapa);

        return new MapaLineal(informacionMapaEnMatriz);
    }

    /*
    @Test
    public void seAgregaUnJugadorEnAlgoRoma(){
        Tablero tablero = new Tablero(mapaConFieraSalvaje());
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        Jugador jugador = new Gladiador();
        algoRoma.agregarJugador(jugador);
        Assertions.assertEquals(1, algoRoma.verCantidadDeJugadores());
    }
     */

    /*
    @Test
    public void lanzaExcepcionSiQueremosAgregarUnJugadorQueSupereLaCantidadMaximaEstablecida() {
        Tablero tablero = new Tablero(mapaConFieraSalvaje());
        AlgoRoma algoRoma = new AlgoRoma(tablero);
        Jugador jugador = new Gladiador();
        Jugador jugador2 = new Gladiador();
        Jugador jugador3 = new Gladiador();
        Jugador jugador4 = new Gladiador();
        Jugador jugador5 = new Gladiador();
        algoRoma.agregarJugador(jugador);
        algoRoma.agregarJugador(jugador2);
        algoRoma.agregarJugador(jugador3);
        algoRoma.agregarJugador(jugador4);
        CantidadMaximaDeJugadoresAlcanzadaException excepcion = Assertions.assertThrows(
                CantidadMaximaDeJugadoresAlcanzadaException.class,
                () -> algoRoma.agregarJugador(jugador5)
        );
    }
     */
}
