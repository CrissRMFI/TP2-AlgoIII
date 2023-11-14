package Entidades.Jugadores;

import Entidades.Energia.Energia;

public class Senior implements Seniority{
    @Override
    public Seniority ascenderSeniority() {
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        Energia e = new Energia(10);
        energia.afectarEnergia(e);
    }
}
