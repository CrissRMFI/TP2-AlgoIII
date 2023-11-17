package Entidades.Jugadores;

import Entidades.Elementos.Turno;
import Entidades.Energia.Energia;

public class Novato implements Seniority{

    private static Energia energia = new Energia(0);

    @Override
    public Seniority ascenderSeniority(Turno turno) {
        if (turno.turnosJugados() < 8 ) {
            return this;
        }
        return new SemiSinior();
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        energia.afectarEnergia(this.energia);
    }
}
