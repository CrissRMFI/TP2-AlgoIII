package Entidades;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import Entidades.Jugadores.Gladiador;
import Entidades.Errores.CantidadMaximaDeJugadoresAlcanzadaException;

public class AlgoRomaTest {
    @Test
    public void seAgregaUnGladiadorEnAlgoRoma() throws CantidadMaximaDeJugadoresAlcanzadaException{
        AlgoRoma algoRoma = new AlgoRoma(4, 5);
        Gladiador gladiador = new Gladiador();
        algoRoma.agregarJugador(gladiador);
        Assertions.assertEquals(1, algoRoma.verCantidadDeJugadores());
    }

    @Test
    public void lanzaExcepcionSiQueremosAgregarUnJugadorQueSupereLaCantidadMaximaEstablecida()
            throws CantidadMaximaDeJugadoresAlcanzadaException{
        AlgoRoma algoRoma = new AlgoRoma(4, 5);
        Gladiador gladiador = new Gladiador();
        Gladiador gladiador2 = new Gladiador();
        Gladiador gladiador3 = new Gladiador();
        Gladiador gladiador4 = new Gladiador();
        Gladiador gladiador5 = new Gladiador();
        algoRoma.agregarJugador(gladiador);
        algoRoma.agregarJugador(gladiador2);
        algoRoma.agregarJugador(gladiador3);
        algoRoma.agregarJugador(gladiador4);
        CantidadMaximaDeJugadoresAlcanzadaException excepcion = Assertions.assertThrows(
                CantidadMaximaDeJugadoresAlcanzadaException.class,
                () -> algoRoma.agregarJugador(gladiador5)
        );
    }
}
