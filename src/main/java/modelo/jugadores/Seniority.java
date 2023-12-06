package modelo.jugadores;

import modelo.elementos.Turno;
import modelo.energia.Energia;

public interface Seniority {
    public abstract Seniority ascenderSeniority(Turno turno);

    public abstract void aumentarEnergia(Energia energia);

    public abstract String descripcion();
}
