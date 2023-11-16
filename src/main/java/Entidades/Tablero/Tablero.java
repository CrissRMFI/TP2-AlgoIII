package Entidades.Tablero;
import java.util.LinkedList;

import Entidades.Elementos.ValorAzar;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class Tablero {

    private Mapa mapa;
    private LinkedList<Jugador> jugadores;



    public Tablero(Mapa mapa) {
        this.mapa = mapa;
        this.jugadores = new LinkedList<>();
    }

    public void agregarJugador(Jugador jugador) {
        this.jugadores.add(jugador);
        Posicion posicion = new Posicion(0,0);
        mapa.ubicar(jugador,posicion);
        this.enlazarCircularmente(this.jugadores);
     }

    private void enlazarCircularmente (LinkedList<Jugador> jugadores) {
       // TODO: IMplementar logica para lograr lista enlazada circular

    }
    public Casillero obtenerCasillero(Posicion posicion) {
        return this.mapa.obtenerCasillero(posicion);
    };

    public Posicion calcularPosicion (ValorAzar valor) {
        return this.mapa.calcularPosicion(valor);
    }

    public void moverJugador(Gladiador gladiador,Posicion posicion){
        gladiador.posicionar(posicion);
        this.mapa.ubicar(gladiador,posicion);
    }

    public void terminarTurno (Jugador jugador) {
        jugador.finalizarTurno();
    }

    public Jugador siguienteJugador () {
        // TODO: Implementar logica para acceder al siguinete jugador
        return null;
    }

    public Jugador iniciarPartida () {
        // TODO: Implementar logica para que tome un jugador al azar y lo retorne
        return null
    }
}

