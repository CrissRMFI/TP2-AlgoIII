package Entidades.Tablero;

import Entidades.Interactuable;
import Entidades.Jugadores.Jugador;
import Entidades.Premios.Premio;

public class Equipo implements Interactuable, Premio {
    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

}