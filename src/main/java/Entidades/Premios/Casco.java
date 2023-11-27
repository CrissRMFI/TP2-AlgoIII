package Entidades.Premios;

import Entidades.Energia.Energia;

public class Casco extends Equipamiento {

    public Casco () {
        this.jerarquia = JerarquiaEquipos.CASCO;
    }
    @Override
    public Energia energiaAReducir() {
        return new Energia(-15);
    }

    @Override
    public Equipamiento mejorar() {
        return new Armadura();
    }

    @Override
    public boolean sePuedeMejorar() {
        return this.jerarquia.ordinal() == JerarquiaEquipos.values()[JerarquiaEquipos.values().length - 1].ordinal();
    }
}