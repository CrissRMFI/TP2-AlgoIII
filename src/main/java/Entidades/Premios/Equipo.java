package Entidades.Premios;

import Entidades.Energia.Energia;

public abstract class Equipo {
    protected JerarquiaEquipos jerarquia;
    public abstract Energia energiaAReducir();
    public abstract Equipo mejorar();

    public  boolean sePuedeMejorar() {
        return true;
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }
}