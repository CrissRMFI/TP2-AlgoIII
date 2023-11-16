package Entidades;

import java.util.ArrayList;
import Entidades.Jugadores.Gladiador;
import Entidades.Tablero.Tablero;
import Entidades.Elementos.Dado;
import Entidades.Errores.CantidadMaximaDeJugadoresAlcanzadaException;


public class AlgoRoma {
    private ArrayList<Gladiador> jugadores = new ArrayList<Gladiador>();
    private Tablero tablero;
    private Dado dado = new Dado();
    private int limiteDeJugadores;
    private int limiteDeTurnos;

    public AlgoRoma(int limiteDeJugadores, int limiteDeTurnos){
        this.limiteDeJugadores = limiteDeJugadores;
        this.limiteDeTurnos = limiteDeTurnos;
    }

    public void agregarJugador(Gladiador gladiador) throws CantidadMaximaDeJugadoresAlcanzadaException{
        if (jugadores.size() == limiteDeJugadores){
            throw new CantidadMaximaDeJugadoresAlcanzadaException();
        }
        jugadores.add(gladiador);
    }

    public int verCantidadDeJugadores(){
        return jugadores.size();
    }

}
