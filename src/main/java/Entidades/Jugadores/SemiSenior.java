package Entidades.Jugadores;

import Entidades.Energia.Energia;

public class SemiSenior implements Seniority {

    private final Energia energia = new Energia(5);
    private final Turno turnosParaEvolucionar = new Turno(11);

    @Override
    public Seniority ascenderSeniority(Turno turno) {
        if (turno.puedeAscender(turnosParaEvolucionar)) {
            return new Senior();
        }
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        energia.afectarEnergia(this.energia);
    }

    @Override
    public String descripcion() {
        return "Semi Senior";
    }
}