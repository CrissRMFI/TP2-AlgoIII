package modelo.jugadores;
import modelo.elementos.Turno;
import modelo.energia.Energia;

public interface Seniority {
    Seniority ascenderSeniority (Turno turno);
    void aumentarEnergia (Energia energia);

    String descripcion ();
}
