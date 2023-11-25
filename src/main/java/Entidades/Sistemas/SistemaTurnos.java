package Entidades.Sistemas;

import Entidades.Elementos.Turno;

public interface SistemaTurnos {
    public abstract void finalizarTurno ();
    public abstract void perderTurnos (Turno turnos);
    public abstract void habilitar();
    public abstract void deshabilitar ();
    public abstract boolean estaHabilitado ();
}
