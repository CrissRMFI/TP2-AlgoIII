package Entidades.Obstaculos;

import Entidades.Jugadores.Gladiador;
import Entidades.Jugadores.Jugador;

public class FieraSalvaje extends Obstaculo{
    @Override
    public void interactuar(Jugador jugador) {
        jugador.defenderse();
    }
}