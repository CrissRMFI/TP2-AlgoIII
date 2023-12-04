package modelo.jugadores;

import modelo.energia.Energia;
import modelo.elementos.Turno;
public class SemiSenior implements Seniority{
    private  Energia energia = new Energia(5);

    private Turno turnosParaEvolucionar = new Turno(11);
    @Override
    public Seniority ascenderSeniority(Turno turno) {

        if (turno.esMayor(this.turnosParaEvolucionar)) {
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