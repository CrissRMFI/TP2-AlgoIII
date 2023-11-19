package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class EquipoBase extends Equipo {

    public EquipoBase() {
        this.tipoEquipo = Equipamiento.EQUIPOBASE;
    }
    public Energia energiaAReducir() {
        return new Energia(-20);
    }
}
