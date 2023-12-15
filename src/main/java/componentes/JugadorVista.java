package componentes;


import entidades.jugadores.Jugador;
import javafx.scene.layout.HBox;


public abstract class JugadorVista extends HBox {
    protected CasilleroCamino casilleroCamino;
    protected Jugador jugador;

    public void setCasillero(CasilleroCamino casillero) {
        this.casilleroCamino = casillero;
        casillero.agregar(this);
    }

    public Jugador getJugador() {
        return this.jugador;
    }
}
