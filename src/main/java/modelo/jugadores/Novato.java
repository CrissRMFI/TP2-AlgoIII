package modelo.jugadores;

import modelo.elementos.Turno;
import modelo.energia.Energia;

public class Novato implements Seniority{

    private Energia energia = new Energia(0);
    private Turno turnosParaEvolucionar = new Turno(7);

    @Override
    public Seniority ascenderSeniority(Turno turno) {
        if (turno.esMayor(this.turnosParaEvolucionar) ) {
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