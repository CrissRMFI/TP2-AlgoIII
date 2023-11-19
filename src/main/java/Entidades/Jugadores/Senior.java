package Entidades.Jugadores;

public class Senior implements Seniority{
    public Seniority ascenderSeniority(int cantidadDeTurnosJugados){
        return this;
    }

    public int plusDeEnergia(){
        return 10;
    }
}










/*
import Entidades.Energia.Energia;
import Entidades.Elementos.Turno;




public class Senior implements Seniority{

    private static Energia energia = new Energia(10);
    @Override
    public Seniority ascenderSeniority(Turno turnos) {
        return this;
    }

    @Override
    public void aumentarEnergia(Energia energia) {
        energia.afectarEnergia(this.energia);
    }
}


 */