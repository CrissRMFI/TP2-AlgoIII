package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class EquipoBase extends Equipamiento {

    public EquipoBase () {
        this.jerarquia = JerarquiaEquipos.EQUIPO_BASE;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-20);
    }

    @Override
    public Equipamiento mejorar() {
        return new Casco();
    }


}
