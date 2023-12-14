package Entidades;

import Datos.MensajesErrores;
import Datos.MensajesUsuario;
import Entidades.Errores.*;
import Entidades.Jugadores.Jugador;
import Entidades.Jugadores.JugadorGanador;
import Entidades.Jugadores.NoHayGanador;
import Entidades.Tablero.*;
import Entidades.sistemaTurnos.SistemaTurnos;

import java.util.LinkedList;

public class AlgoRoma {
    private final Mapa mapa;
    //private final ListaCircular<Jugador> jugadores;
    //private int rondas;
    private JugadorGanador ganador;
    //private int cantidadTurnosPorRonda;
    private Jugador jugadorActual;

    private SistemaTurnos sistemaTurnos;

    public AlgoRoma(Mapa mapa) {
        this.mapa = mapa;
        //this.jugadores = new ListaCircular<>();
        //this.rondas = 30;
        this.ganador = new NoHayGanador();
        this.sistemaTurnos = new SistemaTurnos(30);
    }

    public void agregarJugador(Jugador jugador) {
        this.mapa.ubicarEnInicio(jugador);
        //this.jugadores.agregarElemento(jugador);
        //this.cantidadTurnosPorRonda++;
        this.sistemaTurnos.agregarJugador(jugador);
    }

    public void comenzarPartida() throws CantidadMinimaDeJugadores {
        this.jugadorActual = sistemaTurnos.comenzarConAleatorio();
    }

    public void comenzarPartidaConElPrimerJugador() throws CantidadMinimaDeJugadores {
        this.jugadorActual = sistemaTurnos.comenzarConElPrimero();
    }

    public Jugador jugarTurno() throws PartidaFinalizada {
        if (this.sistemaTurnos.terminonLosTurnos()) {
            throw new PartidaFinalizada(MensajesErrores.PARTIDA_FINALIZADA);
        }
        Jugador jugadorQueJugo = this.jugadorActual;
        jugadorActual.moverse(this.mapa);
        this.turnoFinalizado(jugadorActual);
        this.jugadorActual = this.sistemaTurnos.siguienteJugador();
        return jugadorQueJugo;
    }

    private void turnoFinalizado(Jugador jugador) {
        if (this.mapa.jugadorGano(jugador)) {
            this.ganador = jugador;
            this.sistemaTurnos.terminarTurnos();
        }
        else {
            this.sistemaTurnos.terminarTurnoJugador();
        }
    }

    public JugadorGanador elGanador() throws PartidaNoFinalizada {
        if (!this.sistemaTurnos.terminonLosTurnos()) {
            throw new PartidaNoFinalizada(MensajesErrores.PARTIDA_NO_FINALIZADA);
        }
        return this.ganador;
    }

    public LinkedList<Casillero> getCasilleros() {
        return this.mapa.getCasilleros();
    }

    public Jugador jugadorActual () {
        return this.sistemaTurnos.jugadorActual();
    }

}
