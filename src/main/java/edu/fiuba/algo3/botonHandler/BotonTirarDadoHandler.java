package edu.fiuba.algo3.botonHandler;

import Entidades.AlgoRoma;
import Entidades.Errores.PartidaFinalizada;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Tablero;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDadoHandler implements EventHandler<ActionEvent> {
    Jugador jugador;
    AlgoRoma juego;
    Tablero tablero;
    public BotonTirarDadoHandler(Jugador jugador, AlgoRoma juego, Tablero tablero){
        this.jugador = jugador;
        this.juego = juego;
        this.tablero = tablero;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.jugador.moverse(this.tablero);
        System.out.print(jugador.miPosicion().posicionLineal());
        System.out.print("         "+ jugador.miPosicion().posicionVertical());
        this.juego.entregarElementos(jugador);
        this.juego.finalizarTurno();
        try {
            this.jugador = this.juego.siguienteJugador();
        } catch (PartidaFinalizada e) {
            throw new RuntimeException(e);
        }
    }
}
