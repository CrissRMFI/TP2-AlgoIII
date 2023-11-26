package Entidades.Equipo;

import Entidades.Energia.Energia;

public abstract class Equipamiento {
    protected JerarquiaEquipos jerarquia;
    public abstract Energia energiaAReducir();
    public abstract Equipamiento mejorar();

    public  boolean sePuedeMejorar() {
        return this.jerarquia.ordinal() < JerarquiaEquipos.values()[JerarquiaEquipos.values().length - 1].ordinal();
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return true;
        //return this.jerarquia.ordinal() == equipamiento.ordinal();
    }
}