package Entidades.Premios;

import Entidades.Energia.Energia;

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
