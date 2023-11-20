package Entidades;

import Entidades.Elementos.DispositivoDeAzar;
import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Posicion;
import Entidades.Tablero.Tablero;
import Entidades.Elementos.Dado;

public class AlgoRoma {
    private ListaCircular<Jugador> jugadores = new ListaCircular<>();
    private int turnosJugados = 0;
    private Tablero tablero;
    private int limiteDeTurnos = 30;

    public AlgoRoma(Tablero tablero){
        this.tablero = tablero;
    }

    public void agregarJugador(Jugador jugador) {
        Posicion posicion = this.tablero.posicionInicial();
        jugador.posicionar(posicion);
        this.jugadores.agregarElemento(jugador);
    }

    public Jugador comenzarPartida(){
        return jugadores.seleccionAleatoria();
    }

    private Jugador siguienteJugador(){
        return this.jugadores.obtener();
    }

    public void finalizarTurno () {
        Jugador jugador = this.jugadores.obtener();
        jugador.finalizarTurno();
        this.jugadores.siguiente();
    }

    public void entregarElementos (Jugador jugador) {
        Posicion posicion = jugador.miPosicion();
        Casillero casillero = this.tablero.obtenerCasillero(posicion);
        casillero.entregarElementos(jugador);
    }
}
