package Entidades.Jugadores;

import Entidades.Energia.Energia;
import Entidades.Elementos.Turno;

public class Senior implements Seniority{
    @Override
    public Seniority ascenderSeniority(Turno turnos) {
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        Energia e = new Energia(10);
        energia.afectarEnergia(e);
    }
}
