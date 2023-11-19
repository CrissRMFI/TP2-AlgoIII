package Entidades.Tablero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CasilleroTest {
    @Test
    public void elCasilleroTieneTienePosicionX20Y30(){
        Casillero casillero = new Casillero(20, 30);
        Assertions.assertEquals(20, casillero.getX());
        Assertions.assertEquals(30, casillero.getY());
    }
}