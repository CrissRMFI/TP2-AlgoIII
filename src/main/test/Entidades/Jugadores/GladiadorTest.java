package Entidades.Jugadores;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GladiadorTest {
    @Test
    public void elGladiadorTiene20PuntosDeEnergia(){
        Gladiador gladiador = new Gladiador();
        Assertions.assertEquals(20, gladiador.obtenerEnergia().getEnergia());

    }
}