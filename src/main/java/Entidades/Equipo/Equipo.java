package Entidades.Equipo;

import Entidades.Elementos.Elemento;
import Entidades.Jugadores.Gladiador;

public interface Equipo extends Elemento {
    public void recibirDanio (Gladiador gladiador);
}
