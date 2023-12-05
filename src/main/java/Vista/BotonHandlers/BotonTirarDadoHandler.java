package Vista.BotonHandlers;

import Entidades.AlgoRoma;
import Entidades.Jugadores.Jugador;
import Entidades.Tablero.Casillero;
import Entidades.Tablero.Mapa;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonTirarDadoHandler implements EventHandler<ActionEvent> {
    Jugador jugador;
    AlgoRoma juego;
    Mapa mapa;

    public BotonTirarDadoHandler(Jugador jugador, AlgoRoma juego, Mapa mapa){
        this.jugador = jugador;
        this.juego = juego;
        this.mapa = mapa;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Casillero c = mapa.obtenerProximoDestino(this.jugador);
        this.jugador.moverse(c);
        this.jugador.obtenerElementos();
        this.jugador.finalizarTurno(this.juego);
    }
}
