package Entidades.Jugadores;
import Entidades.Elementos.Turno;
import Entidades.Energia.Energia;

public interface Seniority {
    public Seniority ascenderSeniority (Turno turno);
    public void aumentarEnergia (Energia energia);
}