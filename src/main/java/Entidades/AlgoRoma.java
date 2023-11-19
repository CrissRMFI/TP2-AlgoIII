package Entidades;

import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Tablero;
import Entidades.Elementos.Dado;

public class AlgoRoma {
    private ListaCircular<Jugador> jugadores = new ListaCircular<>();
    private int turnosJugados = 0;
    private Tablero tablero;
    //private Dado dado = new Dado(6);
    private int limiteDeJugadores = 6;
    private int limiteDeTurnos = 30;
    //private Jugador jugadorActual;

    public AlgoRoma(Tablero tablero){
        this.tablero = tablero;
    }

    public void comenzarPartida(){
        //this.elegirPrimerJugador();
        jugadores.seleccionAleatoria();
        /*
        for (int i=0; i < (limiteDeTurnos*this.verCantidadDeJugadores()); i++){
            this.turnosJugados++;
            this.jugadorActual.jugarTurno(dado, tablero);
            this.pasarAlSiguienteJugador();
        }
         */
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.agregarElemento(jugador);
        //Posicion posicion = this.mapa.obtenerPosicionInicial();
        //jugador.posicionar(posicion);
    }

    /*
    public int verCantidadDeJugadores(){
        return jugadores.size();
    }
     */

    public Jugador obtenerJugadorActual(){
        return jugadores.obtener();
    }

    private void pasarAlSiguienteJugador(){
        this.jugadores.siguiente();
    }
}
