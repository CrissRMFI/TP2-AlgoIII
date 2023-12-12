package Componentes;

import Entidades.Jugadores.Jugador;
import javafx.scene.layout.HBox;

public abstract class ModeloJugador extends HBox {
    protected CasilleroCamino casilleroCamino;
    protected Jugador jugador;
    public void setCasillero(CasilleroCamino casillero) {
        this.casilleroCamino = casillero;
        casillero.agregar(this);
    }

    public Jugador getJugador () {
        return this.jugador;
    }

    public boolean comparar (ModeloJugador jugador) {
        return this.jugador.yoSoy() == jugador.getJugador().yoSoy();
    }
}
