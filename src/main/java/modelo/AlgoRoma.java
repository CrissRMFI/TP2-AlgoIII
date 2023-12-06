package modelo;

import datos.MensajesErrores;
import datos.MensajesUsuario;
import modelo.errores.*;
import modelo.jugadores.Jugador;
import modelo.jugadores.JugadorGanador;
import modelo.jugadores.NoHayGanador;
import modelo.tablero.*;
import utils.ListaCircular;

public class AlgoRoma {
    private final ListaCircular<Jugador> jugadores = new ListaCircular<>();
    private int turnos = 30;
    private final Mapa mapa;
    private JugadorGanador ganador;

    public AlgoRoma(Mapa mapa) {
        this.mapa = mapa;
        this.ganador = new NoHayGanador();
    }

    public void agregarJugador(Jugador jugador) {
        this.mapa.ubicarEnInicio(jugador);
        this.jugadores.agregarElemento(jugador);
    }

    public Jugador comenzarPartida() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesUsuario.CANTIDAD_MINIMA_JUGADORES);
        }
        Jugador jugador = jugadores.seleccionAleatoria();
        jugador.habilitar();
        return jugador;
    }

    public Jugador comenzarPartidaConElPrimerJugador() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesErrores.CANTIDAD_MINIMA_JUGADORES);
        }
        Jugador jugador = jugadores.iniciarConElPrimero();
        jugador.habilitar();
        return jugador;
    }

    public Jugador siguienteJugador() throws PartidaFinalizada {
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

    public void turnoFinalizado(Jugador jugador) {

        if (this.mapa.jugadorGano(jugador)) {
            this.finalizar(jugador);
        }

        if (this.turnos != 0) {
            this.sumarUnTurno();
        }
    }

    private void finalizar(JugadorGanador jugadorGanador) {
        this.ganador = jugadorGanador;
        this.turnos = 0;
    }

    private void sumarUnTurno() {
        if (this.jugadores.vueltaCompleta()) {
            this.turnos--;
        }
    }

    public JugadorGanador elGanador() throws PartidaNoFinalizada {
        if (this.turnos != 0) {
            throw new PartidaNoFinalizada(MensajesErrores.PARTIDA_NO_FINALIZADA);
        }
        return this.ganador;
    }
}
