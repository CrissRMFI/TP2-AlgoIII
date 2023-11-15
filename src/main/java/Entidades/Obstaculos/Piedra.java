package Entidades.Obstaculos;

import Entidades.Elementos.Turno;
import Entidades.Jugadores.Gladiador;

public class Piedra implements Obstaculo {
    @Override
    public void enfrentar(Gladiador gladiador) {
        gladiador.deshabilitar();
    }
}