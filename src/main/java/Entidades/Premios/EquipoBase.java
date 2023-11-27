package Entidades.Premios;

import Entidades.Energia.Energia;

public class EquipoBase extends Equipamiento {

    public EquipoBase () {
        this.jerarquia = JerarquiaEquipos.EQUIPO_BASE;
        this.energiaQueAbsorbe = new Energia(0);
    }

    @Override
    public Equipamiento mejorar() {
        return new Casco();
    }
}
