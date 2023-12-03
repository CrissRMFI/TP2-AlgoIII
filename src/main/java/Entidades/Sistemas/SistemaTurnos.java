package Entidades.Sistemas;

import Entidades.AlgoRoma;
import Entidades.Elementos.Turno;

public interface SistemaTurnos {
    void finalizarTurno (AlgoRoma algoRoma);
    void perderTurnos (Turno turnos);
    void habilitar();
}
