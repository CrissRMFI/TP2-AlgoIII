package Entidades.Obstaculos;

import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class FieraSalvaje implements Obstaculo{
@Override
    public void interactuar(Jugador jugador) {
        jugador.defenderse();
    }
}
