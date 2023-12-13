package Componentes;


import javafx.scene.layout.HBox;

import java.util.Objects;

public abstract class Jugador extends HBox {
    protected CasilleroCamino casilleroCamino;
    protected Entidades.Jugadores.Jugador jugador;
    public void setCasillero(CasilleroCamino casillero) {
        this.casilleroCamino = casillero;
        casillero.agregar(this);
    }
    public Entidades.Jugadores.Jugador getJugador () {return this.jugador;}

}
