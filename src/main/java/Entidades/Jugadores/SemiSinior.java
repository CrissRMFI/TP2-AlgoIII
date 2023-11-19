package Entidades.Jugadores;

import Entidades.Energia.Energia;
import Entidades.Elementos.Turno;
public class SemiSinior implements Seniority{
    private static Energia energia = new Energia(5);

    @Override
    public Seniority ascenderSeniority(Turno turno) {

        if (turno.turnosJugados() < 12) {
            return this;
        }
        return new Senior();
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        energia.afectarEnergia(this.energia);
    }
}
