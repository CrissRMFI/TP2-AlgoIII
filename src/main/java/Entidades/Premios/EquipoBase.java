package Entidades.Premios;

import Entidades.Energia.Energia;

public class EquipoBase extends Equipo {

    public EquipoBase () {
        this.jerarquia = JerarquiaEquipos.EQUIPO_BASE;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-20);
    }

    @Override
    public Equipo mejorar() {
        return new Casco();
    }


}
