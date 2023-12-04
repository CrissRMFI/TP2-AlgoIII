package modelo.sistemas;

import modelo.AlgoRoma;
import modelo.elementos.Turno;

public interface SistemaTurnos {
    void finalizarTurno(AlgoRoma algoRoma);

    void perderTurnos(Turno turnos);

    boolean habilitar();
}
