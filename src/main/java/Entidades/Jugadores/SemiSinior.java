package Entidades.Jugadores;

import Entidades.Energia.Energia;
import Entidades.Elementos.Turno;
public class SemiSinior implements Seniority{
    @Override
    public void aumentarEnergia(Energia energia) {
        Energia e = new Energia(5);
        energia.afectarEnergia(e);
    }

    @Override
    public Seniority ascenderSeniority(Turno turno) {

        if (turno.turnosJugados() < 10) {
            return this;
        }
        return new Senior();
    }
}
