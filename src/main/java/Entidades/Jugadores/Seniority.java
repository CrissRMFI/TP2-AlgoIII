package Entidades.Jugadores;

import Entidades.Energia.Energia;

public interface Seniority {

    Seniority ascenderSeniority(int turnos);

    void aumentarEnergia(Energia energia);

    String descripcion();
}
