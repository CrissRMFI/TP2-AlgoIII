package modelo.jugadores;


import modelo.energia.Energia;

public class Senior implements Seniority {

    private Energia energia;

    Senior() {
        this.energia = new Energia(10);
    }

    @Override
    public Seniority ascenderSeniority(int turnos) {
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