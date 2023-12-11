package Entidades.Jugadores;

import Entidades.Energia.Energia;

public class SemiSenior implements Seniority {

    private Energia energia;
    private final int turnosParaEvolucionar;

    public SemiSenior() {
        this.energia = new Energia(5);
        this.turnosParaEvolucionar = 11;
    }

    @Override
    public Seniority ascenderSeniority(int turnos) {
        if (turnos > this.turnosParaEvolucionar) {
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