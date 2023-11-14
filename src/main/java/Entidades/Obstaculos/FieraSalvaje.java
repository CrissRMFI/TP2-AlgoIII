package Entidades.Obstaculos;

import Entidades.Jugadores.Gladiador;

public class FieraSalvaje implements Obstaculo{

    @Override
    public void enfrentar(Gladiador gladiador) {
        gladiador.recibirDanio();
    }
}
