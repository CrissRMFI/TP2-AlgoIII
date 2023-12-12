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
    private JugadorGanador ganador;
    private Jugador jugadorActual;
    private SistemaDeTurnos sistemaDeTurnos;

    public AlgoRoma(Mapa mapa) {
        this.mapa = mapa;
        this.sistemaDeTurnos = new SistemaDeTurnos(30);
        this.ganador = new NoHayGanador();
    }

    public void agregarJugador(Jugador jugador) {
        this.mapa.ubicarEnInicio(jugador);
        this.sistemaDeTurnos.agregarJugador(jugador);
    }

    /*
    public Jugador mover() throws CantidadMinimaDeJugadores, PartidaFinalizada {
        Jugador jugador;
        if (this.turnosJugados == 0) {
            jugador = this.comenzarPartidaConElPrimerJugador();
        } else {
            jugador = this.siguienteJugador();
        }

        Casillero casillero = this.mapa.obtenerProximoDestino(jugador);
        jugador.moverse(casillero);
        jugador.obtenerElementos();
        jugador.finalizarTurno(this);

        return jugador;
    }




    public void comenzarPartida() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesUsuario.CANTIDAD_MINIMA_JUGADORES);
        }
        this.jugadorActual = jugadores.seleccionAleatoria();
        //return jugadores.seleccionAleatoria();
    }


    public void comenzarPartidaConElPrimerJugador() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesErrores.CANTIDAD_MINIMA_JUGADORES);
        }
        this.jugadorActual = jugadores.iniciarConElPrimero();
        //return jugadores.iniciarConElPrimero();
    }
    */


    public Jugador jugarTurno() throws PartidaFinalizada, CantidadMinimaDeJugadores, JuegoTerminadoHayUnGanador {
        this.jugadorActual = this.sistemaDeTurnos.siguienteJugadorPruebas();
        this.jugadorActual.moverse(this.mapa);
        this.turnoFinalizado(this.jugadorActual);
        if (this.sistemaDeTurnos.esUltimoTurno()){
            throw new PartidaFinalizada(MensajesErrores.PARTIDA_FINALIZADA);
        }
        return this.jugadorActual;
    }

    /*
    private Jugador siguienteJugador() throws PartidaFinalizada {
        if (this.turnos == 0) {
            throw new PartidaFinalizada(MensajesErrores.PARTIDA_FINALIZADA);
        }
        this.jugadores.siguiente();
        Jugador jugador = this.jugadores.obtener();

        if (!jugador.habilitar()) {
            this.turnoFinalizado(jugador);

            this.siguienteJugador();
            return this.jugadores.obtener();
        }

        return jugador;
    }

     */




    private void turnoFinalizado(Jugador jugador) throws JuegoTerminadoHayUnGanador {
        if (this.mapa.jugadorGano(jugador)) {
            throw new JuegoTerminadoHayUnGanador();
        }
    }


    /*
    public JugadorGanador elGanador() throws PartidaNoFinalizada {
        if (this.rondas != 0) {
            throw new PartidaNoFinalizada(MensajesErrores.PARTIDA_NO_FINALIZADA);
        }
        return this.ganador;
    }

     */

    public LinkedList<Casillero> getCasilleros() {
        return this.mapa.getCasilleros();
    }

}
