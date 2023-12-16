package entidades.sistemaTurnos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {
    @Test
    void cantidadDeTurnos() {
        Turno turno = new Turno();
        assertEquals(0, turno.cantidadDeTurnos());
    }

    @Test
    void finalizarTurno() {
        Turno turno = new Turno();
        turno.finalizarTurno();
        assertEquals(1, turno.cantidadDeTurnos());
    }

    @Test
    void esMayorQue() {
        Turno turno = new Turno(99);
        Turno turno1 = new Turno(2);
        assertTrue(turno.esMayorQue(turno1));
    }

    @Test
    void restarTurno() {
        Turno turno = new Turno(99);
        turno.restarTurno();
        assertEquals(98, turno.cantidadDeTurnos());
    }

    @Test
    void esMenorA() {
        Turno turno = new Turno(99);
        Turno turno1 = new Turno(2);
        assertTrue(turno1.esMenorA(turno));
    }

    @Test
    void sumarTurno() {
        Turno turno = new Turno(99);
        turno.sumarTurno();
        assertEquals(100, turno.cantidadDeTurnos());
    }

    @Test
    void esIgualA() {
        Turno turno = new Turno(-2);
        Turno turno1 = new Turno();
        turno1.restarTurno();
        turno1.restarTurno();
        assertTrue(turno.esIgualA(turno1));
    }
}