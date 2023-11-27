package Entidades.Premios;

import Entidades.Energia.Energia;

public class Casco extends Equipamiento {

    public Casco () {
        this.jerarquia = JerarquiaEquipos.CASCO;
        this.energiaQueAbsorbe = new Energia(5);
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