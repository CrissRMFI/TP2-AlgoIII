package Entidades.Equipo;

import Entidades.Energia.Energia;
import Entidades.Jugadores.Gladiador;

public class Llave extends DecoradorEquipo{
    Energia energia;

    public Llave () {
        this.energia = new Energia(0);
    }

}
