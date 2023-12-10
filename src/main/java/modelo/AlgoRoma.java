package modelo;

import datos.MensajesErrores;
import datos.MensajesUsuario;
import modelo.errores.*;
import modelo.jugadores.Jugador;
import modelo.jugadores.JugadorGanador;
import modelo.jugadores.NoHayGanador;
import modelo.tablero.*;
import utils.ListaCircular;

import java.util.List;

public class AlgoRoma {

    private final Mapa mapa;

    private final ListaCircular<Jugador> jugadores;
    private int rondas;
    private JugadorGanador ganador;
    private int cantidadTurnosPorRonda;
    private Jugador jugadorActual;

    public AlgoRoma(Mapa mapa) {
        this.mapa = mapa;
        this.jugadores = new ListaCircular<>();
        this.rondas = 30;
        this.ganador = new NoHayGanador();
        this.cantidadTurnosPorRonda = 0;
    }

    public void agregarJugador(Jugador jugador) {
        this.mapa.ubicarEnInicio(jugador);
        this.jugadores.agregarElemento(jugador);
        this.cantidadTurnosPorRonda++;
    }

    public void comenzarPartida() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesUsuario.CANTIDAD_MINIMA_JUGADORES);
        }

        this.jugadorActual = jugadores.seleccionAleatoria();
    }

    public void comenzarPartidaConElPrimerJugador() throws CantidadMinimaDeJugadores { // TODO: crear criterio de seleccion
        if (this.jugadores.tamanio() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesErrores.CANTIDAD_MINIMA_JUGADORES);
        }
        this.jugadorActual = jugadores.iniciarConElPrimero();
    }

    public Jugador jugarTurno() throws PartidaFinalizada {
        Jugador jugadorQueJugo = this.jugadorActual;
        if (this.rondas == 0) {
            throw new PartidaFinalizada(MensajesErrores.PARTIDA_FINALIZADA);
        }
        jugadorActual.moverse(this.mapa);
        //jugadorActual.obtenerElementos();
        //jugadorActual.finalizarTurno(this);
        this.turnoFinalizado(jugadorActual);
        this.jugadorActual = this.jugadores.siguiente();
        return jugadorQueJugo;
    }



    public void turnoFinalizado(Jugador jugador) {
        if (this.mapa.jugadorGano(jugador)) {
            this.ganador = jugador;
            this.rondas = 0;
        }

        this.cantidadTurnosPorRonda--;
        if (this.cantidadTurnosPorRonda == 0) {
            this.rondas--;
            this.cantidadTurnosPorRonda = this.jugadores.tamanio();
        }
    }

    public JugadorGanador elGanador() throws PartidaNoFinalizada {
        if (this.rondas != 0) {
            throw new PartidaNoFinalizada(MensajesErrores.PARTIDA_NO_FINALIZADA);
        }
        return this.ganador;
    }
}
