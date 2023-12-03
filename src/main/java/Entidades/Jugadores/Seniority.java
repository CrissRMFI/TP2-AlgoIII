package Entidades.Jugadores;
import Entidades.Elementos.Turno;
import Entidades.Energia.Energia;

public interface Seniority {
    Seniority ascenderSeniority (Turno turno);
    void aumentarEnergia (Energia energia);

    String descripcion ();
}
