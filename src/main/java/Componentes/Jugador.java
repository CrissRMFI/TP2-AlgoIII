package Componentes;


import javafx.scene.layout.HBox;

public abstract class Jugador extends HBox {
    protected CasilleroCamino casilleroCamino;
    protected Entidades.Jugadores.Jugador jugador;
    public void setCasillero(CasilleroCamino casillero) {
        this.casilleroCamino = casillero;
        casillero.agregar(this);
    }

    protected Entidades.Jugadores.Jugador getJugador () {return this.jugador;}

    public boolean comparar (Jugador jugador) {
        return this.jugador.yoSoy() == jugador.getJugador().yoSoy();
    }
}
