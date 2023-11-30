package Entidades.Premios;

import Entidades.Energia.Energia;

import java.util.Arrays;

public class Casco extends Equipo {

    public Casco () {
        this.jerarquia = JerarquiaEquipos.CASCO;
        this.energiaQueAbsorbe = new Energia(5);
    }

    @Override
    public Equipo mejorar() {
        return new Armadura();
    }

    @Override
    public boolean sePuedeMejorar() {
        return this.jerarquia.ordinal() == JerarquiaEquipos.values()[JerarquiaEquipos.values().length - 1].ordinal();
    }
}