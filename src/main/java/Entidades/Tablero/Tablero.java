package Entidades.Tablero;
import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Jugador;
import Entidades.ListaCircular;

public class Tablero {

    private final Mapa mapa;
    private final ListaCircular<Jugador> jugadores;

    public Tablero(Mapa mapa) {
        this.mapa = mapa;
        this.jugadores = new ListaCircular<>();
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.agregarElemento(jugador);
        Posicion posicion = this.mapa.obtenerPosicionInicial();
        jugador.posicionar(posicion);
    }

     public Casillero obtenerCasillero(Posicion posicion) {
        return this.mapa.obtenerCasillero(posicion);
    }

    public Posicion calcularPosicion (ValorAzar valor) {
        return this.mapa.calcularPosicion(valor);
    }
    public void terminarTurno () {
        Jugador jugador = this.jugadores.obtener();
        jugador.finalizarTurno();
    }

    public Jugador siguienteJugador () {
        Jugador jugador = this.jugadores.siguiente();
        jugador.iniciarTurno();
        return this.jugadores.obtener();
    }

    public Jugador iniciarPartida () {
        Jugador jugador = this.jugadores.seleccionAleatoria();
        jugador.iniciarTurno();
        return jugador;
    }
}

