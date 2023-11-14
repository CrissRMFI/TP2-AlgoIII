package Entidades.Jugadores;

import Entidades.Energia.Energia;

public class Novato implements Seniority{
    @Override
    public Seniority ascenderSeniority() {
        return new SemiSinior();
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        Energia e = new Energia(0);
        energia.afectarEnergia(e);
    }
}
