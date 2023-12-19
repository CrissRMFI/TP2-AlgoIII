package entidades.jugadores;

import entidades.energia.Energia;
import entidades.sistemaTurnos.Turno;

public interface Seniority {

    Seniority ascenderSeniority(Turno turno);

    void aumentarEnergia(Energia energia);

    String descripcion();
}
