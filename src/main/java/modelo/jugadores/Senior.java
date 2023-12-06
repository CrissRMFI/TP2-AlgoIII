package modelo.jugadores;

import modelo.energia.Energia;
import modelo.elementos.Turno;

public class Senior implements Seniority {

    private Energia energia = new Energia(10);

    @Override
    public Seniority ascenderSeniority(Turno turnos) {
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