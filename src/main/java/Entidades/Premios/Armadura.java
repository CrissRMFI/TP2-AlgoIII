package Entidades.Premios;

import Entidades.Energia.Energia;

public class Armadura extends Equipamiento {

    public Armadura () {
        this.jerarquia = JerarquiaEquipos.ARMADURA;
        this.energiaQueAbsorbe = new Energia(10);
    }

    @Override
    public Equipamiento mejorar() {
        return new EscudoYEspada();
    }
    @Override
    public boolean sePuedeMejorar() {
        return this.jerarquia.ordinal() == JerarquiaEquipos.values()[JerarquiaEquipos.values().length - 1].ordinal();

    }
}