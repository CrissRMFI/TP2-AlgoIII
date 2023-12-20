package entidades;

import datos.MensajesErrores;
import entidades.errores.CantidadMinimaDeJugadores;
import entidades.errores.PartidaFinalizada;
import entidades.errores.PartidaNoFinalizada;
import entidades.jugadores.Jugador;
import entidades.jugadores.JugadorGanador;
import entidades.jugadores.NoHayGanador;
import entidades.sistemaTurnos.SistemaTurnos;
import entidades.tablero.Casillero;
import entidades.tablero.Mapa;

import java.util.LinkedList;

public class AlgoRoma {
    private final Mapa mapa;
    private JugadorGanador ganador;
    private Jugador jugadorActual;
    private SistemaTurnos sistemaTurnos;

    public AlgoRoma(Mapa mapa) {
        this.mapa = mapa;
        this.ganador = new NoHayGanador();
        this.sistemaTurnos = new SistemaTurnos(30);
    }

    public void agregarJugador(Jugador jugador) {
        this.mapa.ubicarEnInicio(jugador);
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
        } else {
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


}
