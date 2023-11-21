package Entidades;

import Entidades.Elementos.ValorAzar;
import Entidades.Equipo.Equipamiento;
import Entidades.Errores.*;
import Entidades.Jugadores.Jugador;
import Entidades.Sistemas.SistemaControlGanador;
import Entidades.Tablero.*;

public class AlgoRoma {
    private ListaCircular<Jugador> jugadores = new ListaCircular<>();
    private int turnos= 30;
    private Tablero tablero;
    private SistemaControlGanador controlGanador;
    private Jugador ganador;

    public AlgoRoma(Tablero tablero){
        this.tablero = tablero;
        this.controlGanador = new SistemaControlGanador(tablero);
    }

    public void agregarJugador(Jugador jugador) {
        Posicion posicion = this.tablero.posicionInicial();
        jugador.posicionar(posicion);
        this.jugadores.agregarElemento(jugador);
    }

    public Jugador comenzarPartida() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            Mensajes m = new Mensajes();
            throw new CantidadMinimaDeJugadores(m.CantidadMinimaJugadores());
        }
        Jugador jugador = jugadores.seleccionAleatoria();
        jugador.habilitar();
        return jugador;
    }

    public Jugador comenzarPartidaConElPrimerJugador() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            Mensajes m = new Mensajes();
            throw new CantidadMinimaDeJugadores(m.CantidadMinimaJugadores());
        }
        Jugador jugador = jugadores.seleccionElPrimero();
        jugador.habilitar();
        return jugador;
    }

    public Jugador siguienteJugador() throws PartidaFinalizada {
        if (this.turnos == 0) {
            throw new PartidaFinalizada(new Mensajes().PartidaFinalizada());
        }
        Jugador jugador = this.jugadores.obtener();
        jugador.habilitar();
        return jugador;
    }

    public void finalizarTurno () {
        Jugador jugador = this.jugadores.obtener();
        this.controlGanador.gano(jugador,this);
        jugador.finalizarTurno();
        this.sumarUnTurno();
        this.jugadores.siguiente();

        if (this.turnos == 0 && this.ganador == null) {
            this.finalizarJuego(this.ganador);
        }


    }

    public void entregarElementos (Jugador jugador) throws SinDispositivoDeAzar {
        Posicion posicion = jugador.miPosicion();
        Casillero casillero = this.tablero.obtenerCasillero(posicion);
        casillero.entregarElementos(jugador);
    }

    private void sumarUnTurno () {
        if (this.jugadores.vueltaCompleta()) {
            this.turnos--;
        }
    }

    public Jugador elGanador () throws PartidaNoFinalizada {
        if (this.turnos != 0) {
            throw new PartidaNoFinalizada(new Mensajes().PartidaNoFinalizada());
        }
        return this.ganador;
    }
    public void finalizarJuego (Jugador jugador) {
        this.turnos = 0;
        this.ganador = jugador;
    }
}
