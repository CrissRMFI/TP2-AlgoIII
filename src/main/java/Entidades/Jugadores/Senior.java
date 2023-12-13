package Entidades.Jugadores;

import Entidades.Energia.Energia;

public class Senior implements Seniority {

    private Energia energia;

    public Senior() {
        this.energia = new Energia(10);
    }

    @Override
    public Seniority ascenderSeniority(Turno turno) {
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        energia.afectarEnergia(this.energia);
    }

    @Override
    public String descripcion() {
        return "Senior";
    }
}