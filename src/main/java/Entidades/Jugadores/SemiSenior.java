package Entidades.Jugadores;

import Entidades.Energia.Energia;
import Entidades.Elementos.Turno;
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
}