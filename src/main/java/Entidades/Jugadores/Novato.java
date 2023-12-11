package Entidades.Jugadores;

import Entidades.Energia.Energia;

public class Novato implements Seniority {

    private Energia energia;
    private final int turnosParaEvolucionar;

    public Novato() {
        this.energia = new Energia(0);
        this.turnosParaEvolucionar = 7;
    }

    @Override
    public Seniority ascenderSeniority(int turnos) {
        if (turnos > this.turnosParaEvolucionar) {
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