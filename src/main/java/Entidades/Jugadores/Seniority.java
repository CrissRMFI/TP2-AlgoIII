package Entidades.Jugadores;
import Entidades.Elementos.Turno;
import Entidades.Energia.Energia;

public interface Seniority {
    public abstract Seniority ascenderSeniority (Turno turno);

    public abstract void aumentarEnergia (Energia energia);

    public abstract String descripcion ();
}
