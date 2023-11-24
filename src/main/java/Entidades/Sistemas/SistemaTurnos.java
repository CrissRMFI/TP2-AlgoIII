package Entidades.Sistemas;

import Entidades.Elementos.Turno;

public interface SistemaTurnos {
    void finalizarTurno ();
    void perderTurnos (Turno turnos);
    void habilitar();
    void deshabilitar ();
    boolean estaHabilitado ();
}
