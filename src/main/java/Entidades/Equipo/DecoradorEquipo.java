package Entidades.Equipo;

import Entidades.Energia.Energia;

public abstract class DecoradorEquipo implements Equipo {
    protected Energia energia;
    private Equipo equipo;

    public abstract Energia recibirDanio();
}
