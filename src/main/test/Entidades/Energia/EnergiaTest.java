package Entidades.Energia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EnergiaTest {
    @Test
    public void hay30DeEnergiaDisponible(){
        Energia energia = new Energia(30);
        Assertions.assertEquals(30, energia.getEnergia());
    }
}
