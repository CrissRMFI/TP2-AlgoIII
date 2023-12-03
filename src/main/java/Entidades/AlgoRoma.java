package Entidades;

import Datos.MensajesErrores;
import Datos.MensajesUsuario;
import Entidades.Errores.*;
import Entidades.Jugadores.Jugador;
import Entidades.Jugadores.JugadorGanador;
import Entidades.Jugadores.NoHayGanador;
import Entidades.Tablero.*;

public class AlgoRoma {
    private final ListaCircular<Jugador> jugadores = new ListaCircular<>();
    private int turnos= 30;
    private final Mapa mapa;
    private JugadorGanador ganador;
    private final MensajesUsuario mensaje = new MensajesUsuario();


    public AlgoRoma(Mapa mapa){
        this.mapa = mapa;
        this.ganador = new NoHayGanador();
    }

    public void agregarJugador(Jugador jugador) {
        jugador.ingresar(this.mapa);
        this.jugadores.agregarElemento(jugador);
    }

    public Jugador comenzarPartida() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            throw new CantidadMinimaDeJugadores(this.mensaje.CantidadMinimaDeJugadores());
        }
        Jugador jugador = jugadores.seleccionAleatoria();
        jugador.habilitar();
        return jugador;
    }

    public Jugador comenzarPartidaConElPrimerJugador() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            MensajesErrores m = new MensajesErrores();
            throw new CantidadMinimaDeJugadores(m.CantidadMinimaJugadores());
        }
        Jugador jugador = jugadores.iniciarConElPrimero();
        jugador.habilitar();
        return jugador;
    }

    public Jugador siguienteJugador() throws PartidaFinalizada {
        if (this.turnos == 0) {
            throw new PartidaFinalizada(new MensajesErrores().PartidaFinalizada());
        }
        this.jugadores.siguiente();
        Jugador jugador = this.jugadores.obtener();
        jugador.habilitar();
        return jugador;
    }

    public void turnoFinalizado(Jugador jugador) {

        if (this.mapa.jugadorGano(jugador)) {
            this.finalizar(jugador);
        }

        if (this.turnos!=0) {
            this.sumarUnTurno();
        }
    }

    private void finalizar (JugadorGanador jugadorGanador) {
        this.ganador = jugadorGanador;
        this.turnos = 0;
    }

    private void sumarUnTurno () {
        if (this.jugadores.vueltaCompleta()) {
            this.turnos--;
        }
    }

    public JugadorGanador elGanador () throws PartidaNoFinalizada {
        if (this.turnos != 0) {
            throw new PartidaNoFinalizada(new MensajesErrores().PartidaNoFinalizada());
        }
        return this.ganador;
    }
}
