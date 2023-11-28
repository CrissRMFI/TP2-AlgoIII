package Entidades;

import Datos.MensajesErrores;
import Entidades.Errores.*;
import Entidades.Jugadores.Jugador;
import Entidades.Sistemas.ControlCaracteres;
import Entidades.Sistemas.SistemaControlGanador;
import Entidades.Tablero.*;

public class AlgoRoma {
    private final ListaCircular<Jugador> jugadores = new ListaCircular<>();
    private int turnos= 30;
    private final Tablero tablero;
    private final SistemaControlGanador controlGanador;

    private final ControlCaracteres controlCaracteres;
    private Jugador ganador;

    public AlgoRoma(Tablero tablero){
        this.tablero = tablero;
        this.controlGanador = new SistemaControlGanador(tablero);
        this.controlCaracteres = new ControlCaracteres();
    }

    public void agregarJugador(Jugador jugador) throws ElNombreDebeContenerUnMinimoDe4Caracteres {
        if (!this.controlCaracteres.minimoCuatroCaracteres(jugador.miNombre())) {
            throw new ElNombreDebeContenerUnMinimoDe4Caracteres(new MensajesErrores().Minimo4Caracteres());
        }
        Posicion posicion = this.tablero.posicionInicial();
        jugador.posicionar(posicion);
        this.jugadores.agregarElemento(jugador);
    }

    public Jugador comenzarPartida() throws CantidadMinimaDeJugadores {
        if (this.jugadores.tamanio() < 2) {
            MensajesErrores m = new MensajesErrores();
            throw new CantidadMinimaDeJugadores(m.CantidadMinimaJugadores());
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

    public void finalizarTurno () {
        Jugador jugador = this.jugadores.obtener();
        this.controlGanador.gano(jugador,this);
        jugador.finalizarTurno();
        if (this.turnos!=0) {
            this.sumarUnTurno();
        }

        if (this.turnos == 0 && this.ganador == null) {
            this.finalizarJuego(this.ganador);
        }


    }

    public void entregarElementos (Jugador jugador)  {
        Posicion posicion = jugador.miPosicion();
        Casillero casillero = this.tablero.obtenerCasillero(posicion);
        if (casillero != null) {
            casillero.entregarElementos(jugador);
        }

    }

    private void sumarUnTurno () {
        if (this.jugadores.vueltaCompleta()) {
            this.turnos--;
        }
    }

    public Jugador elGanador () throws PartidaNoFinalizada {
        if (this.turnos != 0) {
            throw new PartidaNoFinalizada(new MensajesErrores().PartidaNoFinalizada());
        }
        return this.ganador;
    }
    public void finalizarJuego (Jugador jugador) {
        this.turnos = 0;
        this.ganador = jugador;
    }
}
