package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Premios.Premio;

public abstract class Equipamiento {
    protected JerarquiaEquipos jerarquia;
    public abstract Energia energiaAReducir();
    public abstract Equipamiento mejorar();

    public  boolean sePuedeMejorar() {
        return true;
        //return this.jerarquia.ordinal() < JerarquiaEquipos.values()[JerarquiaEquipos.values().length - 1].ordinal();
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }
}