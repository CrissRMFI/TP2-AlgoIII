package Entidades.Jugadores;

import Entidades.Energia.Energia;
import Entidades.Elementos.Turno;

public class Senior implements Seniority{

    private static Energia energia = new Energia(10);
    @Override
    public Seniority ascenderSeniority(Turno turnos) {
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        energia.afectarEnergia(this.energia);
    }
}