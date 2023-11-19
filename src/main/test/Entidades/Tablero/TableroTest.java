package Entidades.Tablero;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableroTest {
    @Test
    public void elTableroTiene9Filasy6Columnas(){
        Tablero tablero = new Tablero(9, 6);
        Assertions.assertEquals(9, tablero.getFilas());
        Assertions.assertEquals(6, tablero.getColumnas());
    }
}
