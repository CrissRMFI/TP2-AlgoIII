package Entidades.Jugadores;

public class SemiSenior implements Seniority{
    public Seniority ascenderSeniority(int cantidadDeTurnosJugados){
        if (cantidadDeTurnosJugados < 13){
            return this;
        }
        return new Senior();
    }

    public int plusDeEnergia(){
        return 5;
    }
}



/*
import Entidades.Energia.Energia;
import Entidades.Elementos.Turno;
public class SemiSenior implements Seniority{
    private static Energia energia = new Energia(5);

    @Override
    public Seniority ascenderSeniority(Turno turno) {

        if (turno.turnosJugados() < 10) {
            return this;
        }
        return new Senior();
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        energia.afectarEnergia(this.energia);
    }
}

 */
