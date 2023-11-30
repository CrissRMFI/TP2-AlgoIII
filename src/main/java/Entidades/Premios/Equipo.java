package Entidades.Premios;

import Entidades.Energia.Energia;

public abstract class Equipo {
    protected JerarquiaEquipos jerarquia;
    public abstract Energia energiaAReducir();
    public abstract Equipo mejorar();

    public boolean esEquipoMaximo(){
        return this.jerarquia.equals(JerarquiaEquipos.LLAVE);
    }

    public boolean compararEquipo (JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }
}