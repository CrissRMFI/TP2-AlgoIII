package Entidades;

import Datos.MensajesErrores;
import Entidades.Errores.*;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.*;

import java.util.LinkedList;

public class AlgoRoma {
    private final Mapa mapa;
    private Jugador jugadorActual;
    private SistemaDeTurnos sistemaDeTurnos;

    public AlgoRoma(Mapa mapa) {
        this.mapa = mapa;
        this.sistemaDeTurnos = new SistemaDeTurnos(30);
    }

    public void agregarJugador(Jugador jugador) {
        this.mapa.ubicarEnInicio(jugador);
        this.sistemaDeTurnos.agregarJugador(jugador);
    }

    public Jugador jugarTurno() throws PartidaFinalizada, CantidadMinimaDeJugadores, JuegoTerminadoHayUnGanador {
        this.jugadorActual = this.sistemaDeTurnos.siguienteJugadorPruebas();
        this.jugadorActual.moverse(this.mapa);
        this.turnoFinalizado(this.jugadorActual);
        if (this.sistemaDeTurnos.esUltimoTurno()){
            throw new PartidaFinalizada(MensajesErrores.PARTIDA_FINALIZADA);
        }
        return this.jugadorActual;
    }

    private void turnoFinalizado(Jugador jugador) throws JuegoTerminadoHayUnGanador {
        if (this.mapa.jugadorGano(jugador)) {
            throw new JuegoTerminadoHayUnGanador();
        }
    }

    public Jugador getJugadorActual(){
        return this.jugadorActual;
    }

    public LinkedList<Casillero> getCasilleros() {
        return this.mapa.getCasilleros();
    }

}
