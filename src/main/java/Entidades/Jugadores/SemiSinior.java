package Entidades.Jugadores;

import Entidades.Energia.Energia;

public class SemiSinior implements Seniority{
    @Override
    public void aumentarEnergia(Energia energia) {
        Energia e = new Energia(5);
        energia.afectarEnergia(e);
    }

    @Override
    public Seniority ascenderSeniority() {
        return new Senior();
    }
}
