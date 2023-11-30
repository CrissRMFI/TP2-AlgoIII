package Entidades.Premios;

import Entidades.Energia.Energia;

public class EquipoBase extends Equipo {

    public EquipoBase () {
        this.jerarquia = JerarquiaEquipos.EQUIPO_BASE;
        this.energiaQueAbsorbe = new Energia(0);
    }

    @Override
    public Equipo mejorar() {
        return new Casco();
    }
}
