package Entidades.Premios;

import Entidades.Energia.Energia;

public abstract class Equipamiento {
    protected JerarquiaEquipos jerarquia;
    protected Energia energiaQueAbsorbe;

    public abstract Equipamiento mejorar();

    public Energia recibirDanio(Energia energia){
        energia.afectarEnergia(this.energiaQueAbsorbe);
        return energia;
    }

    public  boolean sePuedeMejorar() {
        return true;
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }
}