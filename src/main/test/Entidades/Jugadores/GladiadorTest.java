package Entidades.Jugadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GladiadorTest {
    @Test
    public void elGladiadorTiene20PuntosDeEnergia(){
        Gladiador gladiador = new Gladiador();
        int puntosDeEnergiaDisponible = gladiador.getPuntosDeEnergia();
        Assertions.assertEquals(20, puntosDeEnergiaDisponible);

    }
}