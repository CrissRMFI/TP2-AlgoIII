package Entidades.Equipo;

import Entidades.Elementos.Interactuable;
import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class Equipo implements Interactuable {
    @Override
    public void interactuar(Jugador jugador) {
        jugador.equipar();
    }

}