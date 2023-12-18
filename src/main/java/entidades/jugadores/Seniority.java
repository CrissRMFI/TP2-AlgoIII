package entidades.jugadores;

import entidades.energia.Energia;
import entidades.sistemaTurnos.Turno;

public interface Seniority {

    public abstract Seniority ascenderSeniority(Turno turno);

    public abstract void aumentarEnergia(Energia energia);

    public abstract String descripcion();
}
