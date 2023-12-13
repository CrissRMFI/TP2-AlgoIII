package Entidades;

import Datos.MensajesErrores;
import Datos.MensajesUsuario;
import Entidades.Errores.*;
import Entidades.Jugadores.Jugador;
import Entidades.Jugadores.JugadorGanador;
import Entidades.Jugadores.NoHayGanador;
import Entidades.Tablero.*;

import java.util.LinkedList;

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

    public void comenzarPartidaConElPrimerJugador() throws CantidadMinimaDeJugadores {
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
        this.turnoFinalizado(jugadorActual);
        this.jugadorActual = this.jugadores.siguiente();
        return jugadorQueJugo;
    }

    private void turnoFinalizado(Jugador jugador) {
        if (this.mapa.jugadorGano(jugador)) {
            this.ganador = jugador;
            this.rondas = 0;
        }
        else {
            this.cantidadTurnosPorRonda--;
            if (this.cantidadTurnosPorRonda == 0) {
                this.rondas--;
                this.cantidadTurnosPorRonda = this.jugadores.tamanio();
            }
        }
    }

    public JugadorGanador elGanador() throws PartidaNoFinalizada {
        if (this.rondas != 0) {
            throw new PartidaNoFinalizada(MensajesErrores.PARTIDA_NO_FINALIZADA);
        }
        return this.ganador;
    }

    public LinkedList<Casillero> getCasilleros() {
        return this.mapa.getCasilleros();
    }

    public Jugador jugadorActual () {
        Jugador jugador = this.jugadores.obtener();
        return jugador;
    }

}
