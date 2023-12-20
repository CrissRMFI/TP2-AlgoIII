package entidades.equipo;

import entidades.energia.Energia;

public abstract class Equipo{
    protected JerarquiaEquipos jerarquia;

    public abstract Equipo mejorar();

    public abstract void recibirDanio(Energia energia);

    public boolean sePuedeMejorar() {
        return true;
    }

    public boolean compararEquipo(JerarquiaEquipos equipamiento) {
        return this.jerarquia.ordinal() == equipamiento.ordinal();
    }

    public abstract String descripcion();
}