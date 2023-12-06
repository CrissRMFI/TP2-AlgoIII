package TestListaCircular;

import utils.ListaCircular;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestListaCircular {
    private ListaCircular<Integer> listaEnteros = new ListaCircular<Integer>();
    private ListaCircular<String> listaString = new ListaCircular<String>();

    @Test
    public void LaListaCircularAlIniciarTieneTamanioCero() {
        assertEquals(0, listaEnteros.tamanio());
    }

    @Test
    public void IngresoUnDatoYLaListaTieneLongitudUno() {
        listaEnteros.agregarElemento(1);
        assertEquals(1, listaEnteros.tamanio());
    }

    @Test
    public void IngresoDosDatosYLaListaTieneLongitudDos() {
        listaEnteros.agregarElemento(1);
        listaEnteros.agregarElemento(2);
        assertEquals(2, listaEnteros.tamanio());
    }

    @Test
    public void IngresoDosDatosIgualesYLaListaTieneLongitudDos() {
        listaEnteros.agregarElemento(1);
        listaEnteros.agregarElemento(1);
        assertEquals(2, listaEnteros.tamanio());
    }

    @Test
    public void IngresoDiezDatosYLaListaTieneLongitudDiez() {
        listaEnteros.agregarElemento(1);
        listaEnteros.agregarElemento(1);
        listaEnteros.agregarElemento(2);
        listaEnteros.agregarElemento(2);
        listaEnteros.agregarElemento(2);
        listaEnteros.agregarElemento(3);
        listaEnteros.agregarElemento(67);
        listaEnteros.agregarElemento(789);
        listaEnteros.agregarElemento(12);
        listaEnteros.agregarElemento(456);
        assertEquals(10, listaEnteros.tamanio());
    }

    @Test
    public void IngresoUnDatoYLoObtengo() {
        listaEnteros.agregarElemento(1);
        assertEquals(1, listaEnteros.obtener());
    }

    @Test
    public void IngresoDosDatosYAlObtenerNoEsElPrimeroIngresado() {
        listaEnteros.agregarElemento(1);
        listaEnteros.agregarElemento(2);
        assertEquals(2, listaEnteros.obtener());
        assertNotEquals(1, listaEnteros.obtener());
    }

    @Test
    public void IngresoDiezDatosYAlObtenerEsElUltimoIngresado() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");
        listaString.agregarElemento("ALgoritmos III");
        listaString.agregarElemento("Probabilidad y Estadistica");
        listaString.agregarElemento("Estructura del Computador");
        listaString.agregarElemento("Organizacion de Datos I");
        listaString.agregarElemento("TDA");
        listaString.agregarElemento("Matematica Discreta");
        listaString.agregarElemento("Taller Programacion");
        listaString.agregarElemento("Bases de Datos");

        assertEquals("Bases de Datos", listaString.obtener());
    }

    @Test
    public void IngresoDiezDatosYAlObtenerDiezVecesEsElUltimoIngresado() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");
        listaString.agregarElemento("ALgoritmos III");
        listaString.agregarElemento("Probabilidad y Estadistica");
        listaString.agregarElemento("Estructura del Computador");
        listaString.agregarElemento("Organizacion de Datos I");
        listaString.agregarElemento("TDA");
        listaString.agregarElemento("Matematica Discreta");
        listaString.agregarElemento("Taller Programacion");
        listaString.agregarElemento("Bases de Datos");

        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
        assertEquals("Bases de Datos", listaString.obtener());
    }

    @Test
    public void IngresoDiezDatosRecorroLaListaUnaVezYObtengoElPrimeroIngresado() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");
        listaString.agregarElemento("ALgoritmos III");
        listaString.agregarElemento("Probabilidad y Estadistica");
        listaString.agregarElemento("Estructura del Computador");
        listaString.agregarElemento("Organizacion de Datos I");
        listaString.agregarElemento("TDA");
        listaString.agregarElemento("Matematica Discreta");
        listaString.agregarElemento("Taller Programacion");
        listaString.agregarElemento("Bases de Datos");

        listaString.siguiente();
        assertEquals("ALgoritmos I", listaString.obtener());

    }

    @Test
    public void IngresoDiezDatosRecorroLaListaTresVecesYObtengoElTerceroIngresado() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");
        listaString.agregarElemento("ALgoritmos III");
        listaString.agregarElemento("Probabilidad y Estadistica");
        listaString.agregarElemento("Estructura del Computador");
        listaString.agregarElemento("Organizacion de Datos I");
        listaString.agregarElemento("TDA");
        listaString.agregarElemento("Matematica Discreta");
        listaString.agregarElemento("Taller Programacion");
        listaString.agregarElemento("Bases de Datos");

        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        assertEquals("ALgoritmos III", listaString.obtener());

    }

    @Test
    public void IngresoDiezDatosRecorroLaListaDiezVecesYObtengoUltimoIngresado() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");
        listaString.agregarElemento("ALgoritmos III");
        listaString.agregarElemento("Probabilidad y Estadistica");
        listaString.agregarElemento("Estructura del Computador");
        listaString.agregarElemento("Organizacion de Datos I");
        listaString.agregarElemento("TDA");
        listaString.agregarElemento("Matematica Discreta");
        listaString.agregarElemento("Taller Programacion");
        listaString.agregarElemento("Bases de Datos");

        String cadenaEsperada = listaString.obtener();
        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        listaString.siguiente();
        assertEquals(cadenaEsperada, listaString.obtener());

    }

    @Test
    public void IngresoDosDatosRecorroLaListaUnaVezSeVerificaUnaVueltaCompleta() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");

        listaString.siguiente();
        assertTrue(listaString.vueltaCompleta());

    }

    @Test
    public void IngresoDiezDatosInicioConELPrimeroRecorro9VecesYSeCuentaComoVUeltaCompleta() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");
        listaString.agregarElemento("ALgoritmos III");
        listaString.agregarElemento("Probabilidad y Estadistica");
        listaString.agregarElemento("Estructura del Computador");
        listaString.agregarElemento("Organizacion de Datos I");
        listaString.agregarElemento("TDA");
        listaString.agregarElemento("Matematica Discreta");
        listaString.agregarElemento("Taller Programacion");
        listaString.agregarElemento("Bases de Datos");


        listaString.iniciarConElPrimero();

        for (int i = 0; i < 8; i++) {
            listaString.siguiente();
            assertFalse(listaString.vueltaCompleta());
        }
        listaString.siguiente();
        assertTrue(listaString.vueltaCompleta());

    }

    @Test
    public void IngresoDiezDatosInicioConELPrimeroRecorro19VecesYSeCuentaComoDosVUeltaCompletas() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");
        listaString.agregarElemento("ALgoritmos III");
        listaString.agregarElemento("Probabilidad y Estadistica");
        listaString.agregarElemento("Estructura del Computador");
        listaString.agregarElemento("Organizacion de Datos I");
        listaString.agregarElemento("TDA");
        listaString.agregarElemento("Matematica Discreta");
        listaString.agregarElemento("Taller Programacion");
        listaString.agregarElemento("Bases de Datos");


        listaString.iniciarConElPrimero();
        int vueltas = 0;
        for (int i = 0; i < 19; i++) {
            listaString.siguiente();
            if (listaString.vueltaCompleta()) {
                vueltas++;
            }
        }

        assertEquals(2, vueltas);

    }

    @Test
    public void IngresoDiezDatosInicioConELPrimeroRecorro18VecesYSeCuentaComoUnaVUeltaCompleta() {
        listaString.agregarElemento("ALgoritmos I");
        listaString.agregarElemento("ALgoritmos II");
        listaString.agregarElemento("ALgoritmos III");
        listaString.agregarElemento("Probabilidad y Estadistica");
        listaString.agregarElemento("Estructura del Computador");
        listaString.agregarElemento("Organizacion de Datos I");
        listaString.agregarElemento("TDA");
        listaString.agregarElemento("Matematica Discreta");
        listaString.agregarElemento("Taller Programacion");
        listaString.agregarElemento("Bases de Datos");


        listaString.iniciarConElPrimero();
        int vueltas = 0;
        for (int i = 0; i < 18; i++) {
            listaString.siguiente();
            if (listaString.vueltaCompleta()) {
                vueltas++;
            }
        }

        assertEquals(1, vueltas);

    }
}
