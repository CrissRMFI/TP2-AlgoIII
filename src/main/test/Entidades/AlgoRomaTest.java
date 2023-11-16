package Entidades;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import Entidades.Jugadores.Gladiador;

public class AlgoRomaTest {
    @Test
    public void seAgregaUnGladiadorEnAlgoRoma(){
        AlgoRoma algoRoma = new AlgoRoma(4, 5);
        Gladiador gladiador = new Gladiador();
        algoRoma.agregarJugador(gladiador);
        Assertions.assertEquals(1, algoRoma.verCantidadDeJugadores());
    }

}
