package entidades.jugadores;

import entidades.energia.Energia;
import entidades.errores.NombreDeJugadorConMenosDe4CaracteresExcepcion;
import entidades.premios.JerarquiaEquipos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GladiadorTest {

    @Test
    void seIntentaCrearUnGladiadorConUnNombreDeMenosDe4CaracteresYLanzaExcepcion(){
        assertThrows(NombreDeJugadorConMenosDe4CaracteresExcepcion.class, () -> new Gladiador("Leo"));
    }

    @Test
    void seIntentaCrearUnGladiadorConNombreDeMenosDe4CaracteresPeroConEspaciosYLanzaExcepcion(){
        String nombre = "            Leo           ";
        assertThrows(NombreDeJugadorConMenosDe4CaracteresExcepcion.class, () -> new Gladiador(nombre));
    }

    @Test
    void afectarEnergia() throws NombreDeJugadorConMenosDe4CaracteresExcepcion {
        Gladiador gladiador = new Gladiador("Batmamdsn");
        gladiador.afectarEnergia(new Energia(40));
        assertTrue(gladiador.compararSalud(new Energia(60)));
    }

    @Test
    void compararSalud() throws NombreDeJugadorConMenosDe4CaracteresExcepcion {
        Gladiador gladiador = new Gladiador("Batmamdsn");
        gladiador.afectarEnergia(new Energia(-100));
        assertTrue(gladiador.compararSalud(new Energia(-80)));
    }

    @Test
    void elEquipamientoInicialDeGladiadorEsUnEquipoBase() throws NombreDeJugadorConMenosDe4CaracteresExcepcion {
        Gladiador gladiador = new Gladiador("Batmamdsn");
        assertTrue(gladiador.compararEquipo(JerarquiaEquipos.EQUIPO_BASE));
    }


    @Test
    void equipar() throws NombreDeJugadorConMenosDe4CaracteresExcepcion {
        Gladiador gladiador = new Gladiador("Batmamdsn");
        gladiador.equipar();
        assertTrue(gladiador.compararEquipo(JerarquiaEquipos.CASCO));
    }

}