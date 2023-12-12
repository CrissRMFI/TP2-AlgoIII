package Entidades;

import Datos.MensajesUsuario;
import Entidades.Errores.CantidadMinimaDeJugadores;
import Entidades.Jugadores.Jugador;

import java.util.LinkedList;
import java.util.Random;

public class SistemaDeTurnos {
    int rondasDeTurnos;
    int rondasJugadas;
    int cantidadDeTurnosPorRonda;
    LinkedList<Jugador> jugadores;
    int indiceDeJugadorActual;

    SistemaDeTurnos(int rondasDeTurnos){
        this.rondasDeTurnos = rondasDeTurnos;
        this.rondasJugadas = 0;
        this.cantidadDeTurnosPorRonda = 0;
        this.jugadores = new LinkedList<>();
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
        this.cantidadDeTurnosPorRonda++;
    }

    public Jugador siguienteJugador() throws CantidadMinimaDeJugadores {
        if (this.esPrimerTurno()){
            return this.elegirPrimerJugadorRandom();
        }
        this.indiceDeJugadorActual = (this.indiceDeJugadorActual + 1) % this.jugadores.size();
        return this.jugadores.get(this.indiceDeJugadorActual);
    }

    public Jugador siguienteJugadorPruebas() throws CantidadMinimaDeJugadores {
        if (this.esPrimerTurno()){
            return this.elegirPrimerJugador();
        }
        this.siTerminoUnaRonda();
        this.cantidadDeTurnosPorRonda--;
        this.indiceDeJugadorActual = (this.indiceDeJugadorActual + 1) % this.jugadores.size();
        return this.jugadores.get(this.indiceDeJugadorActual);
    }

    private Jugador elegirPrimerJugador() throws CantidadMinimaDeJugadores {
        if (this.jugadores.size() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesUsuario.CANTIDAD_MINIMA_JUGADORES);
        }
        this.rondasJugadas++;
        this.cantidadDeTurnosPorRonda--;
        this.indiceDeJugadorActual = 0;
        return this.jugadores.get(this.indiceDeJugadorActual);
    }

    private Jugador elegirPrimerJugadorRandom() throws CantidadMinimaDeJugadores {
        if (this.jugadores.size() < 2) {
            throw new CantidadMinimaDeJugadores(MensajesUsuario.CANTIDAD_MINIMA_JUGADORES);
        }
        Random random = new Random();
        this.rondasJugadas++;
        this.cantidadDeTurnosPorRonda--;
        this.indiceDeJugadorActual = random.nextInt(this.jugadores.size());
        return this.jugadores.get(this.indiceDeJugadorActual);
    }

    private boolean esPrimerTurno(){
        return this.rondasJugadas == 0 && cantidadDeTurnosPorRonda == this.jugadores.size();
    }

    private void siTerminoUnaRonda(){
        if (this.cantidadDeTurnosPorRonda == 0){
            this.rondasJugadas++;
            this.cantidadDeTurnosPorRonda = this.jugadores.size();
        }
    }

    public boolean esUltimoTurno(){
        return this.rondasJugadas == this.rondasDeTurnos && cantidadDeTurnosPorRonda == 0;
    }
}
