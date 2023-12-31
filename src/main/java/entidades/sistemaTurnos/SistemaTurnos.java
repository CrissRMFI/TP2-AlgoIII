package entidades.sistemaTurnos;

import datos.MensajesUsuario;
import entidades.errores.CantidadMinimaDeJugadores;
import entidades.jugadores.Jugador;

import java.util.LinkedList;
import java.util.List;

public class SistemaTurnos {
    private Turno turnosPorRonda;
    private int rondasRestantes;
    private List<Jugador> jugadores;
    private int indiceJugadorActual = 0;

    public SistemaTurnos(int rondas) {
        this.turnosPorRonda = new Turno();
        this.rondasRestantes = rondas;
        this.jugadores = new LinkedList<>();
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
        this.turnosPorRonda.sumarTurno();
    }

    public Jugador comenzarConElPrimero() throws CantidadMinimaDeJugadores {
        if (this.jugadores.size() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesUsuario.CANTIDAD_MINIMA_JUGADORES);
        }
        this.indiceJugadorActual = 0;
        return this.jugadores.get(this.indiceJugadorActual);
    }

    public Jugador comenzarConAleatorio() throws CantidadMinimaDeJugadores {
        if (this.jugadores.size() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesUsuario.CANTIDAD_MINIMA_JUGADORES);
        }
        this.indiceJugadorActual = (int) (Math.random() * this.jugadores.size());
        return this.jugadores.get(this.indiceJugadorActual);
    }

    public void terminarTurnos() {
        this.rondasRestantes = 0;
    }

    public boolean terminonLosTurnos() {
        return this.rondasRestantes == 0;
    }

    public Jugador siguienteJugador() {
        this.indiceJugadorActual++;
        if (this.indiceJugadorActual == this.jugadores.size()) {
            this.indiceJugadorActual = 0;
        }
        return this.jugadores.get(this.indiceJugadorActual);
    }

    public void terminarTurnoJugador() {
        this.turnosPorRonda.restarTurno();
        if (this.turnosPorRonda.esIgualA(new Turno())) {
            this.rondasRestantes--;
            this.turnosPorRonda = new Turno(this.jugadores.size());
        }
    }


}
