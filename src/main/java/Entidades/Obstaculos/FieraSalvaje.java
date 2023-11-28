package Entidades.Obstaculos;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Jugador;

public class FieraSalvaje extends Obstaculo{

    private static final int DANIO = -20;

    @Override
    public void interactuar(Jugador jugador) {
        jugador.defenderse(new Energia(DANIO));
    }
}