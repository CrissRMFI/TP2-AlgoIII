package entidades.energia;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergiaTest {

    @Test
    void cantidadDeEnergia() {
        Energia energia = new Energia();
        assertEquals(20, energia.cantidadDeEnergia());
    }

    @Test
    void energiaAceptaComoValorInicialUnNumeroNegativo(){
        Energia energia = new Energia(-22);
        assertEquals(-22, energia.cantidadDeEnergia());
    }

    @Test
    void afectarEnergia() {
        Energia energia = new Energia(10);
        Energia energia2 = new Energia(5);
        energia.afectarEnergia(energia2);
        assertEquals(15, energia.cantidadDeEnergia());
    }

    @Test
    void tengoEnergia(){
        Energia energia = new Energia(-22);
        assertFalse(energia.tengoEnergia());
    }

    @Test
    void tieneEnergiaInclusoSiSuCantidadEsCero(){
        Energia energia = new Energia(0);
        assertTrue(energia.tengoEnergia());
    }

    @Test
    void comparar() {
        Energia energia = new Energia(33);
        Energia energia2 = new Energia(33);
        assertTrue(energia.comparar(energia2));
    }

    @Test
    void descripcion(){
        Energia energia = new Energia(-90);
        assertEquals("-90", energia.descripcion());
    }
}