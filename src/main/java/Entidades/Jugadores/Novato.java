package Entidades.Jugadores;

import Entidades.Elementos.Turno;
import Entidades.Energia.Energia;

public class Novato implements Seniority{
    @Override
    public Seniority ascenderSeniority(Turno turno) {
        if (turno.turnosJugados() < 8 ) {
            return this;
        }
        return new SemiSinior();
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        Energia e = new Energia(0);
        energia.afectarEnergia(e);
    }
}
