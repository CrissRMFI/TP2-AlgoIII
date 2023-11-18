package Entidades.Obstaculos;

import Entidades.Elementos.Turno;
import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class Piedra implements Obstaculo {
    @Override
    public void accionar(Jugador jugador) {
        jugador.accionar(jugador);
    }
}
