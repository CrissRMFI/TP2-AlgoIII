package Entidades.Premios;

import Entidades.Energia.Energia;

public abstract class Equipamiento {
    protected JerarquiaEquipos jerarquia;
    public abstract Energia energiaAReducir();
    public abstract Equipamiento mejorar();

    public  boolean sePuedeMejorar() {
        return true;
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }
}