package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class Armadura extends DecoradorEquipo{

    Energia energia;

    public Armadura () {
        this.energia = new Energia(-10);
    }

}
