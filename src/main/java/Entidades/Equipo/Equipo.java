package Entidades.Equipo;

import Entidades.Elementos.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;
import Entidades.Premios.Premio;

public class Equipo implements Interactuable, Premio {
    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

}