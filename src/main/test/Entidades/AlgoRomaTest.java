package Entidades;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import Entidades.Jugadores.Jugador;
import Entidades.Errores.CantidadMaximaDeJugadoresAlcanzadaException;

public class AlgoRomaTest {
    @Test
    public void seAgregaUnJugadorEnAlgoRoma() throws CantidadMaximaDeJugadoresAlcanzadaException{
        AlgoRoma algoRoma = new AlgoRoma(4, 5);
        Jugador jugador = new Jugador();
        algoRoma.agregarJugador(jugador);
        Assertions.assertEquals(1, algoRoma.verCantidadDeJugadores());
    }

    @Test
    public void lanzaExcepcionSiQueremosAgregarUnJugadorQueSupereLaCantidadMaximaEstablecida()
            throws CantidadMaximaDeJugadoresAlcanzadaException{
        AlgoRoma algoRoma = new AlgoRoma(4, 5);
        Jugador jugador = new Jugador();
        Jugador jugador2 = new Jugador();
        Jugador jugador3 = new Jugador();
        Jugador jugador4 = new Jugador();
        Jugador jugador5 = new Jugador();
        algoRoma.agregarJugador(jugador);
        algoRoma.agregarJugador(jugador2);
        algoRoma.agregarJugador(jugador3);
        algoRoma.agregarJugador(jugador4);
        CantidadMaximaDeJugadoresAlcanzadaException excepcion = Assertions.assertThrows(
                CantidadMaximaDeJugadoresAlcanzadaException.class,
                () -> algoRoma.agregarJugador(jugador5)
        );
    }
}
