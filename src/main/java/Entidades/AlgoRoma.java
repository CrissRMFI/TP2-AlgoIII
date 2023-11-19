package Entidades;

import java.util.ArrayList;
import java.util.Random;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Tablero;
import Entidades.Elementos.Dado;
import Entidades.Errores.CantidadMaximaDeJugadoresAlcanzadaException;


public class AlgoRoma {
    private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private int turnosJugados = 0;
    private Tablero tablero = new Tablero(1, 40);
    private Dado dado = new Dado(6);
    private int limiteDeJugadores;
    private int limiteDeTurnos;
    private Jugador jugadorActual;

    public AlgoRoma(int limiteDeJugadores, int limiteDeTurnos){
        this.limiteDeJugadores = limiteDeJugadores;
        this.limiteDeTurnos = limiteDeTurnos;
    }

    public void comenzarPartida(){
        this.elegirPrimerJugador();
        for (int i=0; i < (limiteDeTurnos*this.verCantidadDeJugadores()); i++){
            this.turnosJugados++;
            this.jugadorActual.jugarTurno(dado, tablero);
            this.pasarAlSiguienteJugador();
        }
    }

    public void agregarJugador(Jugador jugador) throws CantidadMaximaDeJugadoresAlcanzadaException{
        if (jugadores.size() == this.limiteDeJugadores){
            throw new CantidadMaximaDeJugadoresAlcanzadaException();
        }
        jugadores.add(jugador);
    }

    public int verCantidadDeJugadores(){
        return jugadores.size();
    }

    private void elegirPrimerJugador(){
        Random random = new Random();
        this.jugadorActual = jugadores.get(random.nextInt(jugadores.size()));
    }

    public Jugador obtenerJugadorActual(){
        return this.jugadorActual;
    }

    private void pasarAlSiguienteJugador(){
        int indiceDelJugador = this.jugadores.indexOf(this.jugadorActual);
        if (indiceDelJugador+1 == jugadores.size()){
            indiceDelJugador = -1;
        }
        this.jugadorActual = jugadores.get(indiceDelJugador+1);
    }
}
