package Entidades.Obstaculos;

import Entidades.ElementosMapa;
import Entidades.Jugadores.Gladiador;

public interface Obstaculo extends ElementosMapa {
    public void enfrentar (Gladiador gladiador);
}
