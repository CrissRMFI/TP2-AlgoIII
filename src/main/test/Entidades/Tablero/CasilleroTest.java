package Entidades.Tablero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasilleroTest {
    @Test
    public void elCasilleroTieneTienePosicion20(){
        Casillero casillero = new Casillero();
        Posicion posicion = new PosicionLineal(20);
        casillero.ubicarCasillero(posicion);
        Assertions.assertEquals(20, casillero.getPosicion().obtenerCoordenada().valor());
    }
}