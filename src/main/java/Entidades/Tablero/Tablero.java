package Entidades.Tablero;
import java.util.LinkedList;
import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;
import Entidades.ListaCircular;

public class Tablero {

    private Mapa mapa;
    private ListaCircular<Jugador> jugadores;



    public Tablero(Mapa mapa) {
        this.mapa = mapa;
        this.jugadores = new ListaCircular<Jugador>();
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.agregarElemento(jugador);
        Posicion posicion = new Posicion(0,0);
        mapa.ubicar(jugador,posicion);

     }

     public Casillero obtenerCasillero(Posicion posicion) {
        return this.mapa.obtenerCasillero(posicion);
    };

    public Posicion calcularPosicion (ValorAzar valor) {
        return this.mapa.calcularPosicion(valor);
    }

    public void moverJugador(Gladiador gladiador,Posicion posicion){
        gladiador.posicionar(posicion);
        this.mapa.ubicar(gladiador,posicion);
    }

    public void terminarTurno () {
        Jugador jugador = this.jugadores.obtener();
        jugador.finalizarTurno();
    }

    public Jugador siguienteJugador () {
        this.jugadores.siguiente();
        return this.jugadores.obtener();
    }

    public Jugador iniciarPartida () {
        return this.jugadores.seleccionAleatoria();
    }
}

