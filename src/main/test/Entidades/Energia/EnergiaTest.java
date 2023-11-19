package Entidades.Energia;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class EnergiaTest {
    @Test
    public void hay20DeEnergiaDisponible(){
        Energia energia = new Energia(20);
        int energiaDisponible = energia.getEnergia();
        Assertions.assertEquals(20, energiaDisponible);

    }
}
