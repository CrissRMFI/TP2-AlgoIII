package Entidades;

import java.util.ArrayList;
import java.util.Random;
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
    private Gladiador gladiadorActual;

    public AlgoRoma(int limiteDeJugadores, int limiteDeTurnos){
        this.limiteDeJugadores = limiteDeJugadores;
        this.limiteDeTurnos = limiteDeTurnos;
    }

    public void agregarJugador(Gladiador gladiador) throws CantidadMaximaDeJugadoresAlcanzadaException{
        if (jugadores.size() == this.limiteDeJugadores){
            throw new CantidadMaximaDeJugadoresAlcanzadaException();
        }
        jugadores.add(gladiador);
    }

    public int verCantidadDeJugadores(){
        return jugadores.size();
    }

    private void elegirPrimerTurnoDeGladiador(){
        Random random = new Random();
        this.gladiadorActual = jugadores.get(random.nextInt(jugadores.size()));
    }

    public Gladiador obtenerGladiadorActual(){
        return this.gladiadorActual;
    }

    private void pasarAlSiguienteGladiador(){
        int indiceDelGladiador = this.jugadores.indexOf(this.gladiadorActual);
        if (indiceDelGladiador+1 == jugadores.size()){
            indiceDelGladiador = -1;
        }
        this.gladiadorActual = jugadores.get(indiceDelGladiador+1);
    }
}
