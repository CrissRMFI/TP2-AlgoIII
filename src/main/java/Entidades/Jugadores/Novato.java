package Entidades.Jugadores;

import Entidades.Energia.Energia;

public class Novato implements Seniority {

    private final Energia energia = new Energia(0);
    private final Turno turnosParaEvolucionar = new Turno(7);


    @Override
    public Seniority ascenderSeniority(Turno turno) {
        if (turno.puedeAscender(turnosParaEvolucionar)) {
            return new SemiSenior();
        }
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        energia.afectarEnergia(this.energia);
    }

    @Override
    public String descripcion() {
        return "Novato";
    }
}